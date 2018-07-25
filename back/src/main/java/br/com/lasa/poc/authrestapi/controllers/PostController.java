package br.com.lasa.poc.authrestapi.controllers;

import br.com.lasa.poc.authrestapi.services.PostService;
import br.com.lasa.poc.authrestapi.entities.Post;
import br.com.lasa.poc.authrestapi.filters.PostFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping( path = "/api/post" )
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<?> list(@RequestParam @Nullable String title, @RequestParam @Nullable String description) {
        PostFilter postFilter = title != null || description != null ? new PostFilter(title, description) : null;

        List<Post> posts = postService.findAll(postFilter);

        return ResponseEntity.ok(posts);
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<?> add(@RequestBody Post post) throws URISyntaxException {

        postService.save(post);

        return ResponseEntity.created(new URI("/post/" + post.getId())).body(post);
    }

    @RequestMapping( path = "/{id}", method = RequestMethod.PUT )
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Post post) {

        int index = postService.findIndexById(id);

        if (index < 0) return ResponseEntity.notFound().build();

        post.setId(id);

        postService.save(post);

        return ResponseEntity.accepted().body(post);
    }

    @RequestMapping( path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        int index = postService.findIndexById(id);

        if (index < 0) return ResponseEntity.notFound().build();

        postService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {

        int index = postService.findIndexById(id);

        if (index < 0) return ResponseEntity.notFound().build();

        Post post = postService.buscar(id);

        return ResponseEntity.ok().body(post);
    }
}
