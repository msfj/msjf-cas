package com.msjf.finance.cas.modules.imagevalidcode.service.impl;

import com.msjf.finance.cas.facade.imagevalidcode.domain.ImageValidcodeDomain;
import com.msjf.finance.cas.modules.imagevalidcode.emun.ImageValidcodeEnum;
import com.msjf.finance.cas.modules.imagevalidcode.service.ImageValidcodeService;
import com.msjf.finance.cas.modules.util.MD5Util;
import com.msjf.finance.cas.modules.util.VerifyCodeUtils;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service("imageValidcodeService")
public class ImageValidcodeServiceImpl implements ImageValidcodeService {



    private Random generator = new Random();
    private static char[] captchars = { 'a', 'b', 'c', 'd', 'e', 'f', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8' };



    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Response<ImageValidcodeDomain> getBase64ImageValidecode() {
        Response<ImageValidcodeDomain> rs = new Response();
        rs.fail();
        rs.setMsg("begin process...");
//        rs.setErrorCode(Constant.WS_ERROR_FAILURE);
//        rs.setErrorMessage("begin process...");

        HashMap tmpInfo = new HashMap();
        try {
            //doGet(tmpInfo);
            doGetWithRotate(tmpInfo);
        } catch (IOException e) {
            e.printStackTrace();

//            rs.setErrorCode(Constant.WS_ERROR_FAILURE);
//            rs.setErrorMessage(e.toString());
            rs.fail();
            rs.setMsg(e.toString());

            return rs ;
        }
        String validcode = (String)tmpInfo.get("validcode");//发给前台的base64 image
        String realcode = (String)tmpInfo.get("realcode"); //用来存在数据库的用于做校验证的真实值


        //将realcode存于表中，并返回前台一个唯一的标识符
        long currentTime = System.currentTimeMillis();
        int random6 = (int)(Math.random()*900000+100000) ;

        String uniqueID = String.valueOf(currentTime)+":"+String.valueOf(random6)+":"+ MD5Util.string2MD5(realcode.toLowerCase());

        //select * from kifp.cif_send_phone_msg t

        ImageValidcodeDomain imageValidcodeDomain=new ImageValidcodeDomain();
        imageValidcodeDomain.setUniqueID(uniqueID);
        imageValidcodeDomain.setValidcode(validcode);
//        rs.setErrorCode(Constant.WS_ERROR_SUCCESS);
//        rs.setResType(Constant.WS_TYPE_LISTMAP);
//        ArrayList<Map> returnData = new ArrayList<Map>() ;
//        returnData.add(returnMap);
//        rs.setResult(returnData);
        return rs.success(ImageValidcodeEnum.IMAGE_MAKE_SUCCESS,imageValidcodeDomain);
    }


    //******************************************************************************************************************************************
    public void doGetWithRotate(HashMap validecodeInfo )
            throws   IOException
    {


        String realcode = VerifyCodeUtils.generateVerifyCode(4);
        validecodeInfo.put("realcode", realcode);
        int w = 200, h = 80;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, bos, realcode);


        byte[] bytedata = bos.toByteArray();

        StringBuffer sb = new StringBuffer("data:image/jpeg;base64,"); //data:image/png;base64,iVBORw0KGgo
        sb.append( org.apache.commons.codec.binary.Base64.encodeBase64String(bytedata) );
        String base64image = sb.toString() ;
        validecodeInfo.put("validcode", base64image);
        bos.close();

    }


    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
    @Override
    public Response checkImageValidecode(ImageValidcodeDomain imageValidcodeDomain) {
        Response rs = new Response();
        rs.fail();
        rs.setMsg("begin process...");
        try {
            String uniqueID = imageValidcodeDomain.getUniqueID();
            String inputValidecode = imageValidcodeDomain.getValidcode();

            if ( uniqueID == null) {
                 return rs.fail(ImageValidcodeEnum.MSG_PARAM_ERROR);
            }
            if ( inputValidecode == null )  {
                return rs.fail(ImageValidcodeEnum.MSG_PARAM_ERROR);
            }
            String generateTime = "";
            String md5Validecode = "";

            if ( uniqueID.contains(":")) {
                String[] parts = uniqueID.split(":");
                if ( parts != null && parts.length == 3) {
                    generateTime = parts[0];
                    md5Validecode = parts[2];
                } else {
                    return rs.fail(ImageValidcodeEnum.MSG_PARAM_ERROR);
                }
            } else {
                return rs.fail(ImageValidcodeEnum.MSG_PARAM_ERROR);
            }

            if ( generateTime != null && !"".equals(generateTime)) {
                long genTime = Long.parseLong(generateTime) ;
                if ( System.currentTimeMillis() - genTime > 10*60*1000 ) {
                    return rs.fail(ImageValidcodeEnum.IMAGE_OVER_TIME);
                }
            } else {
                return rs.fail(ImageValidcodeEnum.IMAGE_TIME_GET_ERROR);
            }

            if ( md5Validecode != null && !"".equals(md5Validecode)) {
                if ( !md5Validecode.toLowerCase().equals( MD5Util.string2MD5(inputValidecode.toLowerCase()) )  )   {
                     return rs.fail(ImageValidcodeEnum.IMAGE_CHECK_FAILED);
                }
            } else {
                return rs.fail(ImageValidcodeEnum.IMAGE_MD5_ERROR);
            }
            return rs.success(ImageValidcodeEnum.CHECK_SUCCESS);

        } catch (Exception ex)  {
            ex.printStackTrace();
            return rs.fail(ImageValidcodeEnum.IMAGE_CHECK_EXCEPTION);
        }
    }







//******************************************************************************************************************************************


    //*******************************************************************************************
    public void doGet(HashMap validecodeInfo )
            throws   IOException
    {

        BufferedImage image = null ;


        int num = (int) ((Math.random() * 3));
        if (num % 3 == 0) {
            image = generateNumber(validecodeInfo);
            //	} else if (num % 3 == 1) {
            //		image = generateCharacter(validecodeInfo);
        } else {
            image = generateQuestion(validecodeInfo);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", bos);
        byte[] bytedata = bos.toByteArray();

        StringBuffer sb = new StringBuffer("data:image/jpeg;base64,"); //data:image/png;base64,iVBORw0KGgo
        sb.append( org.apache.commons.codec.binary.Base64.encodeBase64String(bytedata) );
        String base64image = sb.toString() ;
        validecodeInfo.put("validcode", base64image);
        bos.close();

    }

//**********************************************************************************************

    @SuppressWarnings("unused")
    private Font getFont()
    {
        Random random = new Random();
        Font[] font = new Font[5];
        font[0] = new Font("Ravie", 0, 45);
        font[1] = new Font("Antique Olive Compact", 0, 45);
        font[2] = new Font("Forte", 0, 45);
        font[3] = new Font("Wide Latin", 0, 40);
        font[4] = new Font("Gill Sans Ultra Bold", 0, 45);
        return font[random.nextInt(5)];
    }

    @SuppressWarnings("unused")
    private Color getRandColor()
    {
        Random random = new Random();
        Color[] color = new Color[10];
        color[0] = new Color(32, 158, 25);
        color[1] = new Color(218, 42, 19);
        color[2] = new Color(31, 75, 208);
        return color[random.nextInt(3)];
    }

    protected Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }





    //******************************************************************************************


    //========================================================================================
    @SuppressWarnings("unchecked")
    private BufferedImage generateNumber(HashMap validecodeInfo )
            throws   IOException
    {

        int width = 64;int height = 22;

        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("Times New Roman", 0, 18));

        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String sRand = "";
        int car = captchars.length - 1;
        for (int i = 0; i < 4; i++)
        {
            String rand = "" + captchars[(this.generator.nextInt(car) + 1)];
            sRand = sRand + rand;
            g.setColor(new Color(30 + random.nextInt(80), 30 + random.nextInt(80), 30 + random.nextInt(80)));
            g.drawString(rand, 15 * i + 4, 16);
        }

        validecodeInfo.put("realcode", sRand) ;



        g.dispose();



        return image ;

    }



    @SuppressWarnings("unused")
    private void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int thickness, Color c)
    {
        g.setColor(c);
        int dX = x2 - x1;
        int dY = y2 - y1;

        double lineLength = Math.sqrt(dX * dX + dY * dY);

        double scale = thickness / (2.0D * lineLength);



        double ddx = -scale * dY;
        double ddy = scale * dX;
        ddx += (ddx > 0.0D ? 0.5D : -0.5D);
        ddy += (ddy > 0.0D ? 0.5D : -0.5D);
        int dx = (int)ddx;
        int dy = (int)ddy;


        int[] xPoints = new int[4];
        int[] yPoints = new int[4];

        xPoints[0] = (x1 + dx);
        yPoints[0] = (y1 + dy);
        xPoints[1] = (x1 - dx);
        yPoints[1] = (y1 - dy);
        xPoints[2] = (x2 - dx);
        yPoints[2] = (y2 - dy);
        xPoints[3] = (x2 + dx);
        yPoints[3] = (y2 + dy);

        g.fillPolygon(xPoints, yPoints, 4);
    }


    //=========================================================
    public static final int WIDTH = 120;
    public static final int HEIGHT = 30;
    @SuppressWarnings("unchecked")
    public BufferedImage generateCharacter( HashMap validecodeInfo )
            throws  IOException {

        //  request.setCharacterEncoding("utf-8");
        // response.setContentType("text/html;charset=utf-8");

        // 创建缓存
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 获得画布
        Graphics g = bi.getGraphics();
        // 设置背影色
        setBackGround(g);

        // 画干扰线
        drawRandomLine(g);
        // 写随机数
        String random =drawRandomNum((Graphics2D) g);


        // 将随机汉字存在session中
        // request.getSession().setAttribute("checkcode",random);
        validecodeInfo.put("realcode", random) ;

        // 将图片写给浏览器
        // ImageIO.write(bi, "jpg",response.getOutputStream());
        return bi;
    }

    private void setBackGround(Graphics g) {
        // 设置颜色
        // g.setColor(Color.WHITE);
        g.setColor(getRandColor(200, 250));
        // 填充区域
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    private void drawRandomLine(Graphics g) {
        // 设置颜色
        // g.setColor(Color.GREEN);
        Random random1 = new Random();

        // 设置线条个数并画线
        for (int i = 0; i < 5; i++) {
            g.setColor(new Color(30 + random1.nextInt(80), 30 + random1.nextInt(80), 30 + random1.nextInt(80)));
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }


    }

    private String drawRandomNum(Graphics2D g){
        StringBuffer sb = new StringBuffer();
        // 设置颜色
        // g.setColor(Color.RED);
        Random random1 = new Random();

        // 设置字体
        g.setFont(new Font("宋体", Font.BOLD, 20));
        // 准备常用汉字集
        String base ="\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
        int x = 5;
        // 控制字数
        for (int i = 0; i < 4; i++) {
            g.setColor(new Color(30 + random1.nextInt(80), 30 + random1.nextInt(80), 30 + random1.nextInt(80)));

            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            // 截取汉字
            String ch = base.charAt(new Random().nextInt(base.length())) + "";
            sb.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI /180, x, 20);
            g.drawString(ch, x, 20);
            // 反向角度
            g.rotate(-degree * Math.PI /180, x, 20);
            x += 30;
        }
        return sb.toString();
    }
    //=======================================================================

    @SuppressWarnings("rawtypes")
    private BufferedImage generateQuestion(HashMap validecodeInfo )
            throws  IOException {



        int width = 160, height = 30;

        String baseStr = generateCheckCode(  validecodeInfo );

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(random, 200, 250));
        g.fillRect(0, 0, width, height);

        String[] fontTypes = { "\u5b8b\u4f53", "\u65b0\u5b8b\u4f53", "\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66" };
        int fontTypesLength = fontTypes.length;

        g.setColor(getRandColor(random, 160, 200));
        g.setFont(new Font("Times New Roman", Font.PLAIN, 14 + random.nextInt(6)));

        for (int i = 0; i < 255; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String [] baseChar = baseStr.split(" ");
        for (int i = 0; i < baseChar.length; i++) {
            g.setColor(getRandColor(random, 30, 150));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypesLength)], Font.BOLD, 22 + random.nextInt(6)));
            g.drawString(baseChar[i], 24 * i + 10, 24);
        }

        g.dispose();

        //  ImageIO.write(image, "jpg",response.getOutputStream());
        return image ;

    }


    private Color getRandColor(Random random, int fc, int bc){
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    @SuppressWarnings("unchecked")
    private String generateCheckCode( HashMap validecodeInfo) {



        Random random = new Random();
        int intTemp;
        int intFirst = random.nextInt(100);
        int intSec = random.nextInt(100);
        String checkCode = "";
        int result = 0;
        switch (random.nextInt(6)) {
            case 0:
                if (intFirst < intSec) {
                    intTemp = intFirst;
                    intFirst = intSec;
                    intSec = intTemp;
                }
                checkCode = intFirst + " - " + intSec + " = ?";
                result = intFirst-intSec;
                break;
            case 1:
                if (intFirst < intSec) {
                    intTemp = intFirst;
                    intFirst = intSec;
                    intSec = intTemp;
                }
                checkCode = intFirst + " - ? = "+(intFirst-intSec);
                result = intSec;
                break;
            case 2:
                if (intFirst < intSec) {
                    intTemp = intFirst;
                    intFirst = intSec;
                    intSec = intTemp;
                }
                checkCode = "? - "+intSec+" = "+(intFirst-intSec);
                result = intFirst;
                break;
            case 3:
                checkCode = intFirst + " + " + intSec + " = ?";
                result = intFirst + intSec;
                break;
            case 4:
                checkCode = intFirst + " + ? ="+(intFirst+intSec);
                result = intSec;
                break;
            case 5:
                checkCode = "? + " + intSec + " ="+(intFirst+intSec);
                result = intFirst;
                break;
        }
        // request.getSession().setAttribute("VERIFY_CODE", result);
        validecodeInfo.put("realcode", String.valueOf(result)) ;

        return checkCode;
    }




}
