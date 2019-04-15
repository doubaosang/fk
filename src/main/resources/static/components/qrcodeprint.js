function printQrCode(url,qrCodeArray) {
    var TSCObj = new ActiveXObject("TSCActiveX.TSCLIB");
    var openport = TSCObj.ActiveXopenport ("Gprinter  GP-1124T");
    if (openport == '0') {
        alert('插件无法加载');
        return false;
    }else{
        //TSCObj.ActiveXsetup("标签宽度","标签高度","打印速度","打印浓度（0-15）",
        // "感应器类别字串型，0 表示使用垂直間距感測器(gap sensor)， 1 表示使用黑標感測器(black mark senso)","Gap/Black mark垂直间距(mm)","Gap/Black mark偏移距离(mm)");
        TSCObj.ActiveXsetup("60","30","1","1","0","2.5","0");//打印机设置
        TSCObj.ActiveXsendcommand("SET TEAR ON");
        TSCObj.ActiveXclearbuffer();
        //var cmd = 'QRCODE 条码X方向起始点,条码Y方向起始点,纠错级别,二维码高度,A(A和M),旋转角度,M2（分为类型1和类型2）,S1 (s1-s8,默认s7),\"1231你好2421341325454353\"';
        //  1 point=1/8 mm
        var xAdded=30*8+2*8;
        var xAddedQrCode=xAdded+20;
        for (x in qrCodeArray)
        {
            if(x%2==0){
                TSCObj.ActiveXsendcommand('QRCODE 20,10,H,4,A,0,M2,S1,\"'+url+qrCodeArray[x]+'\"');
                TSCObj.ActiveXprinterfont(8,190,1,'0',1,1,qrCodeArray[x]);
            }else{
                TSCObj.ActiveXsendcommand('QRCODE '+xAddedQrCode+',10,H,4,A,0,M2,S1,\"'+url+qrCodeArray[x]+'\"');
                TSCObj.ActiveXprinterfont(xAdded+8,190,1,'0',1,1,qrCodeArray[x]);
            }
            if((x>0&&(x%2!=0))||(x==(qrCodeArray.length-1)) ){
                TSCObj.ActiveXprintlabel("1", "1");//（打印份数,每页打印张数）
                TSCObj.ActiveXclearbuffer();//清除
            }
        }
        TSCObj.ActiveXcloseport();

    }

}