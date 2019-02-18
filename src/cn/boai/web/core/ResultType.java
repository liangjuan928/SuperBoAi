package cn.boai.web.core;
         //响应内容类型
public enum ResultType {
	/** 
     * 重定向 
     */  
    Redirect,   
    /** 
     * 转发 
     */  
    Forward,   
    /** 
     * 异步请求 
     */  
    Ajax,  
    /** 
     * 数据流 
     */  
    Stream,  
    /** 
     * 跳转到向下一个控制器 
     */  
    Chain,  
    /** 
     * 重定向到下一个控制器 
     */  
    RedirectChain  
   
}
