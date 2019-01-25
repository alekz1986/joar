		<!--begin::Web font -->
		<script src="<%=request.getContextPath()%>/recursos/js/webfont.js"></script>
		<script>
			WebFont.load({
            google: {"families":["Poppins:300,400,500,600,700","Roboto:300,400,500,600,700"]},
            active: function() {
                sessionStorage.fonts = true;
            }
          });
        </script>
		<!--end::Web font -->

		<!--begin:: Global Mandatory Vendors -->
		<link href="<%=request.getContextPath()%>/recursos/vendors/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" type="text/css" />
		<!--end:: Global Mandatory Vendors -->