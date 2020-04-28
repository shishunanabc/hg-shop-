<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>商城后台管理系统</title>
  	<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>

    <link rel="canonical" href="https://v4.bootcss.com/docs/examples/dashboard/">

    <!-- Bootstrap core CSS -->
	<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >

    <!-- Favicons -->
<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/resource/css/dashboard.css" rel="stylesheet">
    
  </head>
  <body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="javascript:void(0)"  data-toggle="/brand/list" >
              <span data-feather="home"></span>
              		品牌管理 <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="javascript:void(0)"  data-toggle="/spec/list" >
              <span data-feather="home"></span>
              		规格管理 
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="javascript:void(0)"  data-toggle="/category/list" >
              <span data-feather="file"></span>
              		分类管理
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="javascript:void(0)" data-toggle="/spu/list" >
              <span data-feather="shopping-cart"></span>
              	spu管理
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="javascript:void(0)" data-toggle="/sku/list" >
              <span data-feather="users"></span>
              sku管理
            </a>
          </li>
         
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>报表管理</span>
          <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              		月报
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="file-text"></span>
              	周报
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Dashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group mr-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
          </div>
          <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            This week
          </button>
        </div>
      </div>
      <div id="workArea" style="background: rgb(#aabbcc) repeat;">
      	 	
      </div>     
     
     
    </main>
  </div>
</div>
	<script type="text/javascript">
		$(".nav-link").click(function(){
			var url  = $(this).attr("data-toggle");
			$("#workArea").load(url);
			
		})
	
	</script>
</body></html>