<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Summernote_jpgpng_gif___0"></a>Summernote 파일(jpg,png, gif, …) 업로드</h1>
<hr>
<h2 class="code-line" data-line-start=3 data-line-end=4 ><a id="_3"></a>최종결과</h2>
<h3 class="code-line" data-line-start=4 data-line-end=5 ><a id="___4"></a>게시글 조회 영상</h3>

<img src="https://github.com/DoubleDRG/Summernote-FileUpload/assets/147648419/191ad63b-2f00-40d9-92ed-8bea5259290b"></img>

<ul>
<li class="has-line-data" data-line-start="6" data-line-end="7">텍스트 뿐 아니라, JPG파일, PNG파일, GIF파일, 유튜브영상까지 게시글에 담을 수 있습니다.</li>
<li class="has-line-data" data-line-start="7" data-line-end="9">파일의 용량은 300MB까지 허용합니다. 이는 Spring의 application.properties에서 수정할 수 있습니다.</li>
</ul>
<h3 class="code-line" data-line-start=9 data-line-end=10 ><a id="DB____9"></a>DB에 저장된 게시글 정보</h3>

<img src="https://github.com/DoubleDRG/Summernote-FileUpload/assets/147648419/b7dcf852-8c66-4068-8004-43582dd5d298"></img>
<ul>
<li class="has-line-data" data-line-start="10" data-line-end="11">DB에는 파일의 정보(원래 파일명, uuid파일명, 위치경로)를 저장하지 않습니다.</li>
<li class="has-line-data" data-line-start="11" data-line-end="12">DB에는 오직 게시글 객체(title, content(html태그))만 저장합니다.</li>
<li class="has-line-data" data-line-start="12" data-line-end="14">게시글의 내용이 길어지면 오류가 나기 때문에 @Column()의 length 속성 값을 크게 잡아야 합니다.</li>
</ul>
<h3 class="code-line" data-line-start=14 data-line-end=15 ><a id="___14"></a>디스크에 저장된 파일들</h3>

<img src="https://github.com/DoubleDRG/Summernote-FileUpload/assets/147648419/79eedbd2-ed70-4595-b968-190834a15233"></img>
<ul>
<li class="has-line-data" data-line-start="15" data-line-end="16">파일은 DB에 저장하지 않고 디스크에 저장합니다.</li>
<li class="has-line-data" data-line-start="16" data-line-end="17">파일은 용량이 매우 크기 때문에, DB에 저장한다면, 꺼낼 때 시간이 오래 걸려 병목현상이 일어납니다.</li>
<li class="has-line-data" data-line-start="17" data-line-end="19">저장된 파일은 new UrlResource(“file:” + {파일의경로})로 조회할 수 있습니다.</li>
</ul>
<h2 class="code-line" data-line-start=19 data-line-end=20 ><a id="___19"></a>서비스 작동 흐름</h2>
<p class="has-line-data" data-line-start="21" data-line-end="22">에디터에 이미지 파일을 드래그 앤 드롭하고, 해당 이미지가 에디터에 그려지기까지의 과정을 그림으로 나타내면 다음과 같습니다.</p>

<img src="https://github.com/DoubleDRG/Summernote-FileUpload/assets/147648419/1b01a46d-9f4b-4585-a68f-d2c8af15887c"></img>
<p class="has-line-data" data-line-start="23" data-line-end="25">이후에 “저장하기” 버튼을 누르면, form-data방식으로 title과 content를 담은 POST 요청메시지가 서버로 전달됩니다.<br>
서버는 title, content정보를 바탕으로 Post객체를 생성하고, 이를 DB에 저장합니다.</p>
<h2 class="code-line" data-line-start=26 data-line-end=27 ><a id="_26"></a>참고사항</h2>
<p class="has-line-data" data-line-start="27" data-line-end="28">예제를 구현하며 참고했던 자료는 다음과 같습니다.</p>
<ul>
<li class="has-line-data" data-line-start="28" data-line-end="29">영재님 블로그 글:  <a href="https://m.blog.naver.com/pjok1122/221799760658">https://m.blog.naver.com/pjok1122/221799760658</a></li>
<li class="has-line-data" data-line-start="29" data-line-end="30">영재님 github 코드: <a href="https://github.com/pjok1122/summernote-fileupload-jpa">https://github.com/pjok1122/summernote-fileupload-jpa</a></li>
<li class="has-line-data" data-line-start="30" data-line-end="32">Summernote 공식문서 callback관련: <a href="https://summernote.org/deep-dive/#callbacks">https://summernote.org/deep-dive/#callbacks</a></li>
</ul>
<p class="has-line-data" data-line-start="32" data-line-end="33">궁금한 점이 있거나, 더 좋은 방식이 있다면 아래의 메일로 연락해 주세요.</p>
<ul>
<li class="has-line-data" data-line-start="33" data-line-end="34"><a href="mailto:dyl0115@naver.com">dyl0115@naver.com</a></li>
</ul>
