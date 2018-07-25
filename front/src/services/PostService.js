export default class PostService {

    constructor(resource) {
        this.resource = resource('api/post{/id}');
    } 

    listar() {
        return this.resource
            .query()
            .then(res => res.json(), err => {
                console.log(err);
                throw new Error('Não foi possível obter os posts');
            });
    } 
    
    cadastrar(post) {
        if(post._id) {
            return this.resource
                .update({ id: post._id}, post);
        } else {
            return this.resource
                .save(post);    
        }
    }
    
    apagar(id) {
        return this.resource
            .delete({ id })
            .then(null, err => {
                console.log(err);
                throw new Error('Não foi possível remover o post');
            });
    }

    buscar(id) {
        return this.resource
            .get({ id })
            .then(res => res.json());
    }
}