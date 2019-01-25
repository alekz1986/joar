<%@ page import="com.joar.fact.config.Ctes" %>		
		<!--begin::Global Theme Bundle -->
		<script src="<%=request.getContextPath()%>/recursos/assets/demo/base/scripts.bundle.js" type="text/javascript"></script>
		<!--end::Global Theme Bundle -->

		<!--begin::Page Vendors -->
		<script src="<%=request.getContextPath()%>/recursos/assets/vendors/custom/fullcalendar/fullcalendar.bundle.js" type="text/javascript"></script>
		<!--end::Page Vendors -->

		<!--begin::Page Scripts -->
		<!--<script src="<%=request.getContextPath()%>/recursos/assets/app/js/dashboard.js" type="text/javascript"></script>-->
		<!--end::Page Scripts -->
		
		<script type="text/javascript">
			var __EXCEPTION_DEFAULT_TITLE = '<%=Ctes.AppAlert.ERROR_DEFAULT_TITLE%>';
			var __EXCEPTION_DEFAULT_MESSAGE = '<%=Ctes.AppAlert.ERROR_DEFAULT_MESSAGE%>';
		</script>
		<script src="<%=request.getContextPath()%>/recursos/js/app/general.js" type="text/javascript"></script>