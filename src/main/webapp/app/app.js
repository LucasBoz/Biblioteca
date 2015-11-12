angular.module('StarterApp', ['ngRoute', 'ngMaterial','eits.search.tags'])

.controller('AppCtrl', ['$scope','$route','$routeParams','$mdSidenav', '$mdDialog', '$rootScope',
                        function($scope , $route , $routeParams , $mdSidenav , $mdDialog, $rootScope){

}]).run(function($rootScope){
	
	usuarioService.getCurrent({
		callback : function(result) {
			$rootScope.userLogged = result;
		}
	});
})
//================================
//CATEGORIA
//================================
.controller('CategoriesController', function($scope, $location, $routeParams, $mdDialog, $mdToast) {

	$scope.name = "Categories Controller";


	$scope.find = function(){
		categoriaService.find({
			callback : function(result) {
				$scope.categories = result;
				$scope.$apply();
			}
		}); 
	};
	$scope.find();
	//alterar
	$scope.findOne = function(id){
		categoriaService.find( parseInt(id) , {
			callback : function(result) {
				$scope.categoria = result;
				$scope.$apply();
			}
		}); 
	};

	if ($routeParams.id) {	  	  
		$scope.findOne($routeParams.id);
	};
	// Alterar ^^^  
	$scope.submitForm = function(categoria) {
		categoriaService.save(categoria, {
			callback : function(result) {    	       	       
				$location.path('/categorias');
				$scope.$apply();
			},
			errorHandler : function(message, exception) {
				$scope.toast = $mdToast.simple()
				.content('Já existe esse nome de categoria')
				.action('OK')
				.highlightAction(false)
				.position('top right');
				$mdToast.show($scope.toast);
			}
		});
	};
	$scope.showConfirm = function(ev , categoria) {
		var confirm = $mdDialog.confirm()
		.title('Excluir')
		.content('Deseja excluir o item \n' + categoria.nome )           
		.ok('Excluir')
		.cancel('Cancelar')
		.targetEvent(ev);
		$mdDialog.show(confirm).then(function() {
			categoriaService.remove(categoria.id ,  {
				callback : function(result) {    	       	       
					$scope.find();
					$scope.$apply();
				}, 
				errorHandler : function(){
					$scope.toast = $mdToast.simple()
					.content('Categoria associada a livro')
					.action('OK')
					.highlightAction(false)
					.position('top right');
					$mdToast.show($scope.toast);
				}    
			});   

		});
	};
})

//=====================
//HOME
//====================
.controller('HomeController', function($rootScope) {
})

//================================
//USUARIO
//================================
.controller('UsersController', function($scope,$location, $routeParams, $mdDialog, $mdToast, $rootScope) {
	
	
	
//	$scope.perfis = ['Administrador','Usuário'];
	$scope.name = "Users Controller";
	$scope.users = [];
	$scope.user = {};
	$scope.user.endereco = '';
	$scope.user.password = '';
	
	$scope.find = function(){
		usuarioService.find({
			callback : function(result) {
				$scope.users = result;
				$scope.$apply();
			}
		}); 
	};	
	
//	User logado
//	$scope.userLog = usuarioService.getCurrent();
//
	$scope.find();  

	$scope.submitForm = function() {
		if($rootScope.userLogged.perfil == 'ADMINISTRADOR'){	
			usuarioService.save($scope.user, {
				callback : function(result) { 
					$location.path('/usuarios');
					$scope.$apply();
				},
				errorHandler : function(message, exception) {
					$scope.toast = $mdToast.simple()
					.content('Erro de transação')
					.action('OK')
					.highlightAction(false)
					.position('top right');
					$mdToast.show($scope.toast);
				}
			});
		} else {
			$scope.toast = $mdToast.simple()
			.content('O salvamento e a alteração de usuários é apenas permitida para usuários logados como ADMINISTRADOR')
			.action('OK')
			.highlightAction(false)
			.position('top right');
			$mdToast.show($scope.toast);	
		}	
	};
	//alterar
	$scope.findOne = function(id){
		usuarioService.find( parseInt(id) , {
			callback : function(result) {
				$scope.user = result;
				$scope.user.password = "";
				$scope.$apply();
			}
		}); 
	};

	if ($routeParams.id) {	  	  
		$scope.findOne($routeParams.id);
	};
	// Alterar ^^^
	
	
	
	$scope.showConfirm = function(ev , usuario) {
		var confirm = $mdDialog.confirm()
		.title('Excluir')
		.content('Deseja excluir o item ' + usuario.nome )           
		.ok('Excluir')
		.cancel('Cancelar')
		.targetEvent(ev);
		$mdDialog.show(confirm).then(function() {
			usuarioService.remove(usuario.id ,  {
				callback : function(result) {    	       	       
					$scope.find();
					$scope.$apply();
				}, 
				errorHandler : function(){
					$scope.toast = $mdToast.simple()
					.content('Erro ao excluir')
					.action('OK')
					.highlightAction(false)
					.position('top right');
					$mdToast.show($scope.toast);
				}    
			});   

		});
	};
})
//================================
//LIVRO
//================================
.controller('BookController', function($scope, $location, $routeParams ,$mdDialog, $mdToast) {

	$scope.name = "books Controller";
	$scope.books = [];
	$scope.find = function(){
		livroService.find({
			callback : function(result) {
				$scope.books = result;
				$scope.$apply();
			}
		}); 
	};
//	Alterar
$scope.findOne = function(id){
	livroService.find( parseInt(id) , {
		callback : function(result) {
			$scope.livro = result;          
			$scope.$apply();
		}
	}); 
};

if ($routeParams.id) {	  	  
	$scope.findOne($routeParams.id);
};


categoriaService.find({
	callback : function(result) {
		$scope.categories = result;
		$scope.$apply();
	}
});

$scope.find(); 

$scope.submitForm = function() {    
	livroService.save($scope.livro, {    
		callback : function(result) {
			$location.path('/livros');
			$scope.$apply();
		},
		errorHandler : function(message, exception) {
			$scope.toast = $mdToast.simple()
			.content('Erro de transação')
			.action('OK')
			.highlightAction(false)
			.position('top right');
			$mdToast.show($scope.toast);
		}
	});
};
$scope.showConfirm = function(ev , livro) {
	var confirm = $mdDialog.confirm()
	.title('Excluir')
	.content('Deseja excluir o livro ' + livro.nome)           
	.ok('Excluir')
	.cancel('Cancelar')
	.targetEvent(ev);
	$mdDialog.show(confirm).then(function() {
		livroService.remove(livro.id ,  {
			callback : function(result) {    	       	       
				$scope.find();
				$scope.$apply();
			}, 
			errorHandler : function(){
				$scope.toast = $mdToast.simple()
				.content('Erro de exclusão')
				.action('OK')
				.highlightAction(false)
				.position('top right');
				$mdToast.show($scope.toast);
			}    
		});   

	});
};
})
//================================
//ROTAS
//================================
.config(function($routeProvider, $locationProvider, $mdThemingProvider) {
	$mdThemingProvider.theme('default')


	$routeProvider
	//  USUARIO
	.when('/usuario', {
		templateUrl: 'usuario.html',
		controller: 'UsersController'
	}).when('/usuarios', {
		templateUrl: 'usuarios.html',
		controller: 'UsersController'
	}).when('/usuario/:id', {
		templateUrl: 'usuario.html',
		controller: 'UsersController'
	})
	//LIVRO
	.when('/livro', {
		templateUrl: 'livro.html',
		controller: 'BookController'
	}).when('/livro/:id', {
		templateUrl: 'livro.html',
		controller: 'BookController'
	}).when('/livros', {
		templateUrl: 'livros.html',
		controller: 'BookController'
	})
	//CATEGORIA
	.when('/categoria/:id', {
		templateUrl: 'categoria.html',
		controller: 'CategoriesController'
	}).when('/categoria', {
		templateUrl: 'categoria.html',
		controller: 'CategoriesController'
	}).when('/categorias', {
		templateUrl: 'categorias.html',
		controller: 'CategoriesController'
	}).when('/' , {
		templateUrl: 'home.html',
		controller: 'HomeController'				
	})
	//TESTE
	.when('/teste' , {
		templateUrl: 'teste.html',
		controller: 'CategoriesController'				
	})
	//OUTROS
	.otherwise({
		redirectTo : '/'
	});
	//$locationProvider.html5Mode(true);
});
/*  GETTING STARTED  ^^^^ */