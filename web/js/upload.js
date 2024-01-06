// 去左空格
function ltrim(s) {
	return s.replace(/^\s*/, "");
}
// 去右空格
function rtrim(s) {
	return s.replace(/\s*$/, "");
}
// 去左右空格
function trim(s) {
	return rtrim(ltrim(s));
}
// 获取文件扩展名
function get_ext(f_path) {
	var ext = '';
	if (f_path != null && trim(f_path).length > 0) {
		f_path = trim(f_path);
		ext = f_path.substring(f_path.lastIndexOf(".") + 1, f_path.length);
	}
	return ext;
}
// 验证文件扩展名
function chk_ext(f_path) {
	var ext = get_ext(f_path);
	// 根据需求定制
	var accept_ext = new Array( "bmp", "jpeg", "jpg", "gif","png");
	var flag = false;
	if (ext != '') {
		for ( var i = 0; i < accept_ext.length; i++) {
			if (ext == accept_ext[i])
				flag = true;
		}
	}
	return flag;
}

/*★★★★★★★★★★★★★★★★★★★*/
/*
 * <div id="divPreview">
     <img id="imgHeadPhoto" src="Images/Headphoto/noperson.jpg" style="width: 160px; height: 170px;border: solid 1px #d2e2e2;" alt="" />
	</div>
 * 
 */
//js本地图片预览，兼容ie[6-8]、火狐、Chrome17+、Opera11+、Maxthon3
function PreviewImage1(fileObj,imgPreviewId,divPreviewId){
    var allowExtention="bpm,jpeg,jpg,gif";//document.getElementById("hfAllowPicSuffix").value;//.jpg,.bmp,.gif,.png,允许上传文件的后缀名
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();            
    var browserVersion= window.navigator.userAgent.toUpperCase();
    if(allowExtention.indexOf(extention)>-1){               
        if (browserVersion.indexOf("MSIE")>-1){
            if(browserVersion.indexOf("MSIE 6.0")>-1){//ie6
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
            }else{//ie[7-8]、ie9未测试
                fileObj.select();
                var newPreview =document.getElementById(divPreviewId+"New");
                if(newPreview==null){
                    newPreview =document.createElement("div");
                    newPreview.setAttribute("id",divPreviewId+"New");
                    newPreview.style.width = document.getElementById(imgPreviewId).style.width;
                    newPreview.style.height = document.getElementById(imgPreviewId).style.height;
                    newPreview.style.border="solid 1px #d2e2e2";
                }
                newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";                            
                var tempDivPreview=document.getElementById(divPreviewId);
                tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);
                tempDivPreview.style.display="none";                    
            }
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
            if(firefoxVersion<7){//firefox7以下版本
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
            }else{//firefox7.0+                    
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
            }
        }else if(fileObj.files){               
            //兼容chrome、火狐等，HTML5获取路径                   
            if(typeof FileReader !== "undefined"){
                var reader = new FileReader(); 
                reader.onload = function(e){
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                } ; 
                reader.readAsDataURL(fileObj.files[0]);
            }else if(browserVersion.indexOf("SAFARI")>-1){
                alert("暂时不支持Safari浏览器!");
            }
        }else{
            document.getElementById(divPreviewId).setAttribute("src",fileObj.value);
        }         
    }else{
        alert("仅支持"+allowExtention+"为后缀名的文件!");
        fileObj.value="";//清空选中文件
        if(browserVersion.indexOf("MSIE")>-1){                        
            fileObj.select();
            document.selection.clear();
        }                
        fileObj.outerHTML=fileObj.outerHTML;
    }
}

function previewImage(fileObj,imgPreviewId) {
    var pic = document.getElementById(imgPreviewId),
        file = fileObj;
 
    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
 
     // gif在IE浏览器暂时无法显示
     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
         return;
     }
     var isIE = navigator.userAgent.match(/MSIE/)!= null,
         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
 
     if(isIE) {
        file.select();
        var reallocalpath = document.selection.createRange().text;
 
        // IE6浏览器设置img的src为本地路径可以直接显示图片
         if (isIE6) {
            pic.src = reallocalpath;
         }else {
            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
         }
     }else {
        html5Reader(file,imgPreviewId);
     }
}
 
 function html5Reader(file,imgPreviewId){
     var file = file.files[0];
     var reader = new FileReader();
     reader.readAsDataURL(file);
     reader.onload = function(e){
         var pic = document.getElementById(imgPreviewId);
         pic.src=this.result;
     };
 }