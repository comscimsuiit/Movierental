<ul class="nav pull-right btn-inverse btn-mini">
	<li class="dropdown dropdown-btn">
		
		<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    		<i class="icon-info-sign"></i>
			<g:message code="Account"/> <b class="caret"></b>
		</a>
		
		<ul class="dropdown-menu btn-inverse">
			<%-- Note: Links to pages without controller are redirected in conf/UrlMappings.groovy --%>
			<%--<li class="">
				<a href="http://localhost:8080/MovieRental/user/index">
					<i class="icon-info-sign"></i>
					<g:message code="Log out"/>
				</a>
			</li>--%>
			<g:if test="${flash.message }">
				<div class="message">
					${flash.message}
				</div>
			</g:if>
			<g:if test="${session.user }">
			<br/>
				<%--<g:link action="logout">Logout</g:link>--%>
				<g:form controller="user" action="logout">
					<center><input type="submit" class="btn btn-success btn-medium" value="Logout"></center>
				</g:form>
			</g:if>
<%--			<li class="divider"></li>--%>
<%--			<li class=""><a href="${createLink(uri: '/imprint')}">Imprint</a></li>--%>
<%--			<li class=""><a href="${createLink(uri: '/terms')}"><i>Terms of Use</i></a></li>--%>
		</ul>
	</li>
</ul>
