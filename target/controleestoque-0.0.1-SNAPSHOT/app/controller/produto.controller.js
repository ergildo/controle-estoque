app.controller('produtoController', produtoController);

function produtoController($scope, $http) {

    $scope.salvar = salvar;
    $scope.editar = editar;
    $scope.limpar = limpar;
    $scope.excluir = excluir;

    init();

    function init() {
        listar();
    }


    function salvar() {
        $http.post('api/produto', $scope.produto).then(salvarResult, salvarError);
        function salvarResult(response) {
            limpar();
            listar();
        }

        function salvarError(response) {
            console.log(response.data);
        }

    }

    function listar() {
        $http.get('api/produto').then(listarResult, listarError);
        function listarResult(response) {
            $scope.produtos = response.data;
        }

        function listarError(response) {
            console.log(response.data);
        }
    }

    function editar(produto) {
        $scope.produto = produto;
    }

    function excluir(id) {
        $http.delete('api/produto/'+id).then(excluirResult, excluirError);
        function excluirResult(response) {
            limpar();
            listar();
        }

        function excluirError(response) {
            console.log(response.data);
        }
    }

    function limpar() {
        $scope.produto = {};
    }

}
