package com.joar.fact.db.beans;

import java.util.HashMap;
import java.util.Map;

public enum EnumProductoGrupoTipo {

	FAMILIA(1, "familia"),
	SUB_FAMILIA(2, "sub_familia"),
	CATEGORIA(3, "categoria"),
	PRODUCTO(4, "producto");
	
	private int id;
	private String name;
	private static final Map<Integer, EnumProductoGrupoTipo> lookup = new HashMap<>();
	
	EnumProductoGrupoTipo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

    static {
        for(EnumProductoGrupoTipo env : EnumProductoGrupoTipo.values()) {
            lookup.put(env.getId(), env);
        }
    }
  
    public static EnumProductoGrupoTipo get(int id) {
        return lookup.get(id);
    }
	
}
