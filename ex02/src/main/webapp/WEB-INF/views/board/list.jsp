<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<%@ include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Tables</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board List Page
                <button id="regBtn" type="button" class="btn btn-xs btn btn-primary pull-right">REgister New Button</button>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>#번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <c:forEach items="${list}" var="board">
                    	<tr>
                    		<td>${board.bno}</td>
                    		<td><a href='/board/get?bno=${board.bno}'>${board.title}</a></td>
                    		<td>${board.writer}</td>
                    		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/> </td>
                    		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate}"/></td>
                    	</tr>
                    </c:forEach>
                </table>
                
                 <form action="/board/list" method="get" id="actionForm">
				    <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				    <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				</form>
              
                <!-- 페이징 처리 시작 -->
				 <nav aria-label="..."class="pull-right">
				  <ul class="pagination">
				  
				    <c:if test="${pageMaker.prev}">
				    <li class="page-item disabled paginate_button">
				      <a href="${pageMaker.startPage -1}">Previous</a>
				    </li>
				    </c:if>
				    
				    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.
				    endPage}">
				    <li class="page-item paginate_button ${pageMaker.cri.pageNum == num ? "active":""} ">
				    	<a href="${num}">${num}</a>
				    </li>
				    </c:forEach>
				    
				    <c:if test="${pageMaker.next}">
				    <li class="page-item paginate_button">
						<a href="${pageMaker.endPage +1 }">Next</a>
					</li>				    
				    </c:if>
				  </ul>
				</nav>
                <!-- 페이징 처리 종료 -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div> <!-- end row -->           

<!-- modal start -->
<div id="myModal" class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>처리가 완료되었습니다.</p>
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- modal end -->

<script>
  $(document).ready(function() {
    let result = '${result}';
    
    checkModal(result);
    
    history.replaceState({},null,null);
    
    function checkModal(result) {
      if (result === '' || history.state) {
        return;
      }
      
      if (parseInt(result) > 0) {
        $(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
      }
      $("#myModal").modal("show");
    } // end checkModal
    
    /* $("#regBtn").on("click", function() {
      self.location = "/board/register";
    }); */
    
    document.getElementById("regBtn").addEventListener("click",function(){
    	window.location.href= "/board/register"
    });
    
    let actionForm = $("#actionForm");
    $(".paginate_button a").on("click", function(e){
    	e.preventDefault();
    	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
    	actionForm.submit();
    });
  }); // end ready
</script>




<%@ include file="../includes/footer.jsp" %> 