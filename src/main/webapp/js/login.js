$(function() {  // 页面加载的操作处理
    // 需要做一个针对于mid或者是password输入的字段丢失焦点的事件处理
    $("#mid").on("blur",function() {
        validateMid() ;
    }) ;
    $("#password").on("blur",function() {
        validatePassword() ;
    }) ;
    // 对于整个的表单需要进行提交前的检查操作
    $("#loginForm").on("submit",function() {
        return validateMid() && validatePassword() ;    // 验证都通过后可以提交
    }) ;
}) ;
function validateMid() {
    return validateEmpty("mid") ;
}
function validatePassword() {
    return validateEmpty("password") ;
}
/**
 * 本函数的主要功能是验证所传入的数据是否为空，如果为空，则显示错误，同时显示错误信息
 * 如果输入的内容为空，那么对于整个层要求进行错误提示；has-error，通过has-success；
 * 在xxSpan中显示为空的错误信息
 * @param eleId 要判断的元素的ID编号
 */
function validateEmpty(eleId) {
    if($("#" + eleId).val() == "") {  // 如果输入的内容为空
        $("#" + eleId + "Div").attr("class","form-group has-error") ;
        $("#" + eleId + "Span").html("<span class='text-danger'>该字段的内容不允许为空！</span>") ;
        return false ;
    }  else {       // 内容不为空
        $("#" + eleId + "Div").attr("class","form-group has-success") ;
        $("#" + eleId + "Span").html("<span class='text-success'>该字段的内容输入合法！</span>") ;
        return true ;
    }
}