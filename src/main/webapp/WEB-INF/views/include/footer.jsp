<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="${request.getContextPath() }/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="${request.getContextPath() }/resources/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script src="${request.getContextPath() }/resources/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script src="${request.getContextPath() }/resources/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="${request.getContextPath() }/resources/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="${request.getContextPath() }/resources/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="${request.getContextPath() }/resources/plugins/moment/moment.min.js"></script>
	<script src="${request.getContextPath() }/resources/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script src="${request.getContextPath() }/resources/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script src="${request.getContextPath() }/resources/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script src="${request.getContextPath() }/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${request.getContextPath() }/resources/dist/js/adminlte.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${request.getContextPath() }/resources/dist/js/demo.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="${request.getContextPath() }/resources/dist/js/pages/dashboard.js"></script>
</html>