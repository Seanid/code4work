---
title: 微信js-sdk调用 
date: 2016-01-22 23:14:42
tags: 微信
---
微信js-sdk，是微信提供给网页开发设计者使用的，在页面上使用部分微信功能的SDK。关于它的文档，可以通过微信公众平台上获取获取[微信JS-Sdk文档](http://mp.weixin.qq.com/wiki/11/74ad127cc054f6b80759c40f77ec03db.html)

关于如何开发，其实在微信的文档上面已经说得蛮清楚的了，只要按照文档来，大概就能够调得出自己想要的功能了。

调起微信js-sdk，可以分为两个部分，配置部分和编码部分。

配置部分，需要开发者登录到微信公众平台上，对能够进行js-sdk调起的域名进行授权，只有通过授权的域名，才能调起。主要的配置在 公众号设置”的“功能设置”里填写“JS接口安全域名”。设置完成后，在需要调起的页面，导入微信官方给出的js  https://res.wx.qq.com/open/js/jweixin-1.0.0.js，前期的工作就大部分完成了。

编码部分主要分为前端编码和后台编码，因为微信的js-sdk调起的时候，需要向微信服务器传一些验签的参数，而这些参数，在微信官方是推荐由后台进行加密后再传回前端的。

在开始编码之前，首先了解一下从用户使用开始，到调起js-sdk进行操作得当整个流程：

![微信流程](http://image.e65535.com/github/js-sdk-api.png)

<br/>
大致的流程如图所示，用户通过微信客户端访问程序员开发的H5页面，该页面要调起js-sdk的某些功能，则需要在页面加载完成之后，首先请求企业的服务器，申请入appscrte等参数，然后将参数填入wx.config()函数中，该函数主要确定该页面是否可以调起js-sdk，该函数执行完成之后，默认会调用wx.ready()，如果需要页面加载完成后立马调起js-sdk的话，需要将调用的代码放在wx.ready()中。如果不需要，就只需要在根据情况在页面上出发对应的js-sdk提供的函数即可。每个函数，都会有对应的成功与失败的回调函数，前端通过该函数，来实现对应的结果展示就行了。

在这个过程中，前端所需要做的，其实就是根据需求来调起微信js-sdk中的函数。前端重中之中在于页面加载完成之后的wx.config()接入，而后台的任务则是根据微信的算法，对参数进行加密，然后将数据打包返回给前端。

调起js-sdk所后台需要做的可以分为以下几步：

* 通过请求微信服务器获取 access_token
* 通过 access_token获取到调起js-sdk所需要用到的 jsapi_ticket；
* 将 noncestr（随机字符串）， jsapi_ticket， timestamp(时间错)， url（调起js-sdk的网址）四个参数进行排序并加密生产一串加密字符
* 将appId（公众号的唯一标识）， timestamp， nonceStr:，signature（签名）返回给前端


具体需要涉及到的算法如下：

    public static String signatureSHA1(Map<String, String> map) {
     
        Set<String> keySet = map.keySet();
     
        String[] str = new String[map.size()];
     
        StringBuilder tmp = new StringBuilder();
     
        // 进行字典排序
     
        str = keySet.toArray(str);
     
        Arrays.sort(str);
     
        for (int i = 0; i < str.length; i++) {
     
            String t = str[i] + "=" + map.get(str[i]) + "&";
     
            tmp.append(t);
     
        }
     
        String tosend = tmp.toString().substring(0, tmp.length() - 1);
     
        MessageDigest md = null;
     
        byte[] bytes = null;
     
        try {
     
            md = MessageDigest.getInstance("SHA-1");
     
            bytes = md.digest(tosend.getBytes("utf-8"));
     
        } catch (Exception e) {
     
            e.printStackTrace();
     
        }
     
        String singe = byteToStr(bytes);
     
        return singe.toLowerCase();
     
    }


需要注意的是，在前端进行调试的过程中，苹果版的微信会在调出js-sdk出错的时候弹出更加详细的信息，而安卓版有时候只是没反应，连信息都不会弹出，所以建议如果确定后台算法正确的情况下，可以在苹果的微信下进行调试。


具体的项目实例可以看https://github.com/Seanid/wechatPay中页面调起微信支付部分

