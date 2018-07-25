package br.com.lasa.poc.authrestapi.databases;


import br.com.lasa.poc.authrestapi.entities.Post;

import java.util.LinkedList;
import java.util.List;

public final class Database {

    public static final List<Post> POSTS = new LinkedList<>();

    public static Long LAST_INSERTED_ID = 0L;
}
