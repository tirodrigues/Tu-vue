package br.com.lasa.poc.authrestapi.services;

import br.com.lasa.poc.authrestapi.databases.Database;
import br.com.lasa.poc.authrestapi.entities.Post;
import br.com.lasa.poc.authrestapi.filters.PostFilter;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostService {

    public List<Post> findAll() {

        return this.findAll(null);
    }

    public List<Post> findAll(PostFilter postFilter) {

        List<Post> posts = Database.POSTS;

        if (postFilter != null && (postFilter.getTitle() != null || postFilter.getDescription() != null)) {

            Stream<Post> postStream = posts.stream();

            if (postFilter.getTitle() != null) {

                postStream = postStream.filter(post -> post.getTitle().toLowerCase().contains(postFilter.getTitle().toLowerCase()));
            }

            if (postFilter.getDescription() != null) {

                postStream = postStream.filter(post -> post.getDescription().toLowerCase().contains(postFilter.getDescription().toLowerCase()));
            }

            posts = postStream.collect(Collectors.toList());
        }

        return posts;
    }

    public void save(Post post) {

        if (post.getId() == null) {

            post.setId(++Database.LAST_INSERTED_ID);

        } else {

            this.delete(post.getId());
        }

        Database.POSTS.add(post);

        Database.POSTS.sort(Comparator.comparing(Post::getId));
    }

    public void delete(Long id) {

        int index = this.findIndexById(id);

        if (index >= 0) Database.POSTS.remove(index);
    }
    
    public Post buscar(Long id) {

        int index = this.findIndexById(id);

        return Database.POSTS.get(index);
        
    }

    public int findIndexById(Long id) {

        for (int index = 0; index < Database.POSTS.size(); index++) {

            if (Database.POSTS.get(index).getId().equals(id)) return index;
        }

        return -1;
    }
}
