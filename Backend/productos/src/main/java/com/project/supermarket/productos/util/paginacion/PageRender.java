package com.project.supermarket.productos.util.paginacion;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.domain.Page;

public class PageRender<T> {
    // <T> tipo genérico, representa una clase
    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numElementosPorPagina;
    private int paginaActual;
    private List<PageItem> paginas;

    // Constructor
    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();
    }

}
