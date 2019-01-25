package com.joar.fact.config;

public class Ctes {

	public static final String NAMEAPP = "Joar";
	public static final int PRODUCTO_GRUPO_NIVEL_MAX = 4;
	
	public class SubTitulo {
		public class Mantenimiento {
			public static final String PRODUCTO_GRUPO = "Mantenimiento de Grupo de Productos";
			public static final String PRODUCTO = "Mantenimiento de Productos";
		}
	}
	
	public class Session {
		public static final String USUARIO = "SESION_USUARIO";
	}

	
	public class AppAlert {
		public static final String ERROR_DEFAULT_TITLE = "Error";
		public static final String ERROR_DEFAULT_MESSAGE = "Ocurrió un error inesperado.";
		
		public static final String DEFAULT_TITLE = "Alerta";
		public static final String DEFAULT_CONFIRM_BUTTON = "Ok";
		public static final String DEFAULT_CANCEL_BUTTON = "Cancelar";
	}
	
	
}
