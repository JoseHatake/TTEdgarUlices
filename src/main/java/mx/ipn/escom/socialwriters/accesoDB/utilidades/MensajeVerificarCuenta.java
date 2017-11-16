/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.utilidades;

/**
 *
 * @author Lock
 */
public class MensajeVerificarCuenta {
    String cuerpo="";

    public MensajeVerificarCuenta() {
    }
    
    public String creaEspañol(String usuario, String url){
        cuerpo="<!DOCTYPE html>\n" +
"<html lang=\"it\">\n" +
"<head>\n" +
"<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n" +
"<title>MOSAICO Responsive Email Designer</title>\n" +
"<!--\n" +
"\n" +
"\n" +
"COLORE INTENSE  #9C010F\n" +
"COLORE LIGHT #EDE8DA\n" +
"\n" +
"TESTO LIGHT #3F3D33\n" +
"TESTO INTENSE #ffffff \n" +
"\n" +
"\n" +
" --><meta charset=\"utf-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width\">\n" +
"<style type=\"text/css\">#ko_onecolumnBlock_5 .textintenseStyle a, #ko_onecolumnBlock_5 .textintenseStyle a:link, #ko_onecolumnBlock_5 .textintenseStyle a:visited, #ko_onecolumnBlock_5 .textintenseStyle a:hover {color: #fff;color: ;text-decoration: none;text-decoration: none;font-weight: bold;}\n" +
"#ko_onecolumnBlock_5 .textlightStyle a, #ko_onecolumnBlock_5 .textlightStyle a:link, #ko_onecolumnBlock_5 .textlightStyle a:visited, #ko_onecolumnBlock_5 .textlightStyle a:hover {color: #3f3d33;color: ;text-decoration: none;text-decoration: ;font-weight: bold;}</style>\n" +
"<style type=\"text/css\">\n" +
"    /* CLIENT-SPECIFIC STYLES */\n" +
"    #outlook a{padding:0;} /* Force Outlook to provide a \"view in browser\" message */\n" +
"    .ReadMsgBody{width:100%;} .ExternalClass{width:100%;} /* Force Hotmail to display emails at full width */\n" +
"    .ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div{line-height: 100%;} /* Force Hotmail to display normal line spacing */\n" +
"    body, table, td, a{-webkit-text-size-adjust:100%; -ms-text-size-adjust:100%;} /* Prevent WebKit and Windows mobile changing default text sizes */\n" +
"    table, td{mso-table-lspace:0pt; mso-table-rspace:0pt;} /* Remove spacing between tables in Outlook 2007 and up */\n" +
"    img{-ms-interpolation-mode:bicubic;} /* Allow smoother rendering of resized image in Internet Explorer */\n" +
"\n" +
"    /* RESET STYLES */\n" +
"    body{margin:0; padding:0;}\n" +
"    img{border:0; height:auto; line-height:100%; outline:none; text-decoration:none;}\n" +
"    table{border-collapse:collapse !important;}\n" +
"    body{height:100% !important; margin:0; padding:0; width:100% !important;}\n" +
"\n" +
"    /* iOS BLUE LINKS */\n" +
"    .appleBody a{color:#68440a; text-decoration: none;}\n" +
"    .appleFooter a{color:#999999; text-decoration: none;}\n" +
"\n" +
"    /* MOBILE STYLES */\n" +
"    @media screen and (max-width: 525px) {\n" +
"\n" +
"        /* ALLOWS FOR FLUID TABLES */\n" +
"        table[class=\"wrapper\"]{\n" +
"          width:100% !important;\n" +
"          min-width:0px !important;\n" +
"        }\n" +
"\n" +
"        /* USE THESE CLASSES TO HIDE CONTENT ON MOBILE */\n" +
"        td[class=\"mobile-hide\"]{\n" +
"          display:none;}\n" +
"\n" +
"        img[class=\"mobile-hide\"]{\n" +
"          display: none !important;\n" +
"        }\n" +
"\n" +
"        img[class=\"img-max\"]{\n" +
"          width:100% !important;\n" +
"          max-width: 100% !important;\n" +
"          height:auto !important;\n" +
"        }\n" +
"\n" +
"        /* FULL-WIDTH TABLES */\n" +
"        table[class=\"responsive-table\"]{\n" +
"          width:100%!important;\n" +
"        }\n" +
"\n" +
"        /* UTILITY CLASSES FOR ADJUSTING PADDING ON MOBILE */\n" +
"        td[class=\"padding\"]{\n" +
"          padding: 10px 5% 15px 5% !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"padding-copy\"]{\n" +
"          padding: 10px 5% 10px 5% !important;\n" +
"          text-align: center;\n" +
"        }\n" +
"\n" +
"        td[class=\"padding-meta\"]{\n" +
"          padding: 30px 5% 0px 5% !important;\n" +
"          text-align: center;\n" +
"        }\n" +
"\n" +
"        td[class=\"no-pad\"]{\n" +
"          padding: 0 0 0px 0 !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"no-padding\"]{\n" +
"          padding: 0 !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"section-padding\"]{\n" +
"          padding: 10px 15px 10px 15px !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"section-padding-bottom-image\"]{\n" +
"          padding: 10px 15px 0 15px !important;\n" +
"        }\n" +
"\n" +
"        /* ADJUST BUTTONS ON MOBILE */\n" +
"        td[class=\"mobile-wrapper\"]{\n" +
"            padding: 10px 5% 15px 5% !important;\n" +
"        }\n" +
"\n" +
"        table[class=\"mobile-button-container\"]{\n" +
"            margin:0 auto;\n" +
"            width:100% !important;\n" +
"        }\n" +
"\n" +
"        a[class=\"mobile-button\"]{\n" +
"            width:80% !important;\n" +
"            padding: 15px !important;\n" +
"            border: 0 !important;\n" +
"            font-size: 16px !important;\n" +
"        }\n" +
"\n" +
"    }\n" +
"</style>\n" +
"</head>\n" +
"<body style=\"margin: 0; padding: 0;\" align=\"center\" bgcolor=\"#ffffff\">\n" +
"\n" +
"<!-- PREHEADER -->\n" +
"\n" +
"\n" +
"<table id=\"ko_titleBlock_3\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr class=\"row-a\">\n" +
"<td class=\"section-padding\" style=\"padding: 30px 15px 0px 15px;\" bgcolor=\"#c00000\" align=\"center\">\n" +
"            <table style=\"padding: 0 0 20px 0;\" class=\"responsive-table\" width=\"500\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
"<!-- TITLE --><tbody><tr>\n" +
"<td class=\"padding-copy\" colspan=\"2\" style=\"padding: 0 0 10px 0px; font-size: 25px; font-family: Helvetica; font-weight: normal; color: #ffffff;\" align=\"center\"><strong>¡Bienvenido! "+usuario+"</strong></td>\n" +
"                </tr></tbody>\n" +
"</table>\n" +
"</td>\n" +
"    </tr></tbody></table>\n" +
"<table id=\"ko_onecolumnBlock_5\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr class=\"row-a\">\n" +
"<td class=\"section-padding\" style=\"padding-top: 30px; padding-left: 15px; padding-bottom: 30px; padding-right: 15px;\" bgcolor=\"#4bacc6\" align=\"center\">\n" +
"            <table class=\"responsive-table\" width=\"500\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td>\n" +
"                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>\n" +
"<tr>\n" +
"<td>\n" +
"                                    <!-- COPY -->\n" +
"                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>\n" +
"<tr>\n" +
"<td class=\"padding-copy\" style=\"font-size: 25px; font-family: Helvetica, Arial, sans-serif; color: #3F3D33; padding-top: 0px;\" align=\"center\"><strong>Agradecemos que decidieras unirte a nuestra comunidad</strong></td>\n" +
"                                        </tr>\n" +
"<tr>\n" +
"<td class=\"padding-copy textlightStyle\" style=\"padding: 20px 0 0 0; font-size: 16px; line-height: 25px; font-family: Helvetica; color: #000000;\" align=\"center\"><p style=\"margin:0px;\"><strong>Ahora solo necesitas confirmar tu cuenta de correo electronico y podras comenzar a publicar tus obras.</strong><br></p></td>\n" +
"                                        </tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"                            </tr>\n" +
"<tr>\n" +
"<td>\n" +
"                                    <!-- BULLETPROOF BUTTON -->\n" +
"                                    <table class=\"mobile-button-container\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td style=\"padding: 25px 0 0 0;\" class=\"padding-copy\" align=\"center\">\n" +
"                                                <table class=\"responsive-table\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td align=\"center\"><a target=\"_new\" class=\"mobile-button\" style=\"display: inline-block; font-size: 18px; font-family: Helvetica, Arial, sans-serif; font-weight: normal; color: #ffffff; text-decoration: none; background-color: #9C010F; padding-top: 15px; padding-bottom: 15px; padding-left: 25px; padding-right: 25px; border-radius: 3px; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-bottom: 3px solid #5f0109;\" href=\""+url+"\"><strong>Confirmar</strong></a></td>\n" +
"                                                    </tr></tbody></table>\n" +
"</td>\n" +
"                                        </tr></tbody></table>\n" +
"</td>\n" +
"                            </tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"                </tr></tbody></table>\n" +
"</td>\n" +
"    </tr></tbody></table>\n" +
"<!-- FOOTER --><table style=\"min-width: 500px;\" id=\"ko_footerBlock_2\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td bgcolor=\"#ffffff\" align=\"center\">\n" +
"            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody><tr>\n" +
"<td style=\"padding: 20px 0px 20px 0px;\">\n" +
"                        <!-- UNSUBSCRIBE COPY -->\n" +
"                        <table class=\"responsive-table\" width=\"500\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody>\n" +
"<tr>\n" +
"<td style=\"font-size: 12px; line-height: 18px; font-family: Helvetica, Arial, sans-serif; color: #3F3D33;\" valign=\"middle\" align=\"center\">\n" +
"                                    <span class=\"appleFooter\" style=\"color: #3F3D33;\"><strong>Si no eres "+usuario+" o crees que recibiste este correo por error por favor ignoralo</strong></span><br><a class=\"original-only\" href=\"%5Bprofile_link%5D\" style=\"color: #3F3D33; text-decoration: none;\" target=\"_new\"><br data-mce-bogus=\"1\"></a><span class=\"original-only\" style=\"font-family: Arial, sans-serif; font-size: 12px; color: #444444;\">  si el botón no funciona, prueba hacer click sobre la siguiente liga o copia y pega en tu navegador: <a href=\""+url+"\">"+url+"</a></span><a href=\"%5Bshow_link%5D\" style=\"color: #3F3D33; text-decoration: none;\" target=\"_new\"><br data-mce-bogus=\"1\"></a>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"<tr style=\"text-align: center;\">\n" +
"<td>\n" +
"                               \n" +
"                            </td>\n" +
"                            </tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"                </tr></tbody></table>\n" +
"</td>\n" +
"    </tr></tbody></table>\n" +
"</body>\n" +
"</html>\n" +
"";
       return cuerpo; 
    }
    
public String creaIngles(String usuario, String url){
    
    cuerpo="<!DOCTYPE html>\n" +
"<html lang=\"it\">\n" +
"<head>\n" +
"<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n" +
"<title>MOSAICO Responsive Email Designer</title>\n" +
"<!--\n" +
"\n" +
"\n" +
"COLORE INTENSE  #9C010F\n" +
"COLORE LIGHT #EDE8DA\n" +
"\n" +
"TESTO LIGHT #3F3D33\n" +
"TESTO INTENSE #ffffff \n" +
"\n" +
"\n" +
" --><meta charset=\"utf-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width\">\n" +
"<style type=\"text/css\">#ko_onecolumnBlock_5 .textintenseStyle a, #ko_onecolumnBlock_5 .textintenseStyle a:link, #ko_onecolumnBlock_5 .textintenseStyle a:visited, #ko_onecolumnBlock_5 .textintenseStyle a:hover {color: #fff;color: ;text-decoration: none;text-decoration: none;font-weight: bold;}\n" +
"#ko_onecolumnBlock_5 .textlightStyle a, #ko_onecolumnBlock_5 .textlightStyle a:link, #ko_onecolumnBlock_5 .textlightStyle a:visited, #ko_onecolumnBlock_5 .textlightStyle a:hover {color: #3f3d33;color: ;text-decoration: none;text-decoration: ;font-weight: bold;}</style>\n" +
"<style type=\"text/css\">\n" +
"    /* CLIENT-SPECIFIC STYLES */\n" +
"    #outlook a{padding:0;} /* Force Outlook to provide a \"view in browser\" message */\n" +
"    .ReadMsgBody{width:100%;} .ExternalClass{width:100%;} /* Force Hotmail to display emails at full width */\n" +
"    .ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div{line-height: 100%;} /* Force Hotmail to display normal line spacing */\n" +
"    body, table, td, a{-webkit-text-size-adjust:100%; -ms-text-size-adjust:100%;} /* Prevent WebKit and Windows mobile changing default text sizes */\n" +
"    table, td{mso-table-lspace:0pt; mso-table-rspace:0pt;} /* Remove spacing between tables in Outlook 2007 and up */\n" +
"    img{-ms-interpolation-mode:bicubic;} /* Allow smoother rendering of resized image in Internet Explorer */\n" +
"\n" +
"    /* RESET STYLES */\n" +
"    body{margin:0; padding:0;}\n" +
"    img{border:0; height:auto; line-height:100%; outline:none; text-decoration:none;}\n" +
"    table{border-collapse:collapse !important;}\n" +
"    body{height:100% !important; margin:0; padding:0; width:100% !important;}\n" +
"\n" +
"    /* iOS BLUE LINKS */\n" +
"    .appleBody a{color:#68440a; text-decoration: none;}\n" +
"    .appleFooter a{color:#999999; text-decoration: none;}\n" +
"\n" +
"    /* MOBILE STYLES */\n" +
"    @media screen and (max-width: 525px) {\n" +
"\n" +
"        /* ALLOWS FOR FLUID TABLES */\n" +
"        table[class=\"wrapper\"]{\n" +
"          width:100% !important;\n" +
"          min-width:0px !important;\n" +
"        }\n" +
"\n" +
"        /* USE THESE CLASSES TO HIDE CONTENT ON MOBILE */\n" +
"        td[class=\"mobile-hide\"]{\n" +
"          display:none;}\n" +
"\n" +
"        img[class=\"mobile-hide\"]{\n" +
"          display: none !important;\n" +
"        }\n" +
"\n" +
"        img[class=\"img-max\"]{\n" +
"          width:100% !important;\n" +
"          max-width: 100% !important;\n" +
"          height:auto !important;\n" +
"        }\n" +
"\n" +
"        /* FULL-WIDTH TABLES */\n" +
"        table[class=\"responsive-table\"]{\n" +
"          width:100%!important;\n" +
"        }\n" +
"\n" +
"        /* UTILITY CLASSES FOR ADJUSTING PADDING ON MOBILE */\n" +
"        td[class=\"padding\"]{\n" +
"          padding: 10px 5% 15px 5% !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"padding-copy\"]{\n" +
"          padding: 10px 5% 10px 5% !important;\n" +
"          text-align: center;\n" +
"        }\n" +
"\n" +
"        td[class=\"padding-meta\"]{\n" +
"          padding: 30px 5% 0px 5% !important;\n" +
"          text-align: center;\n" +
"        }\n" +
"\n" +
"        td[class=\"no-pad\"]{\n" +
"          padding: 0 0 0px 0 !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"no-padding\"]{\n" +
"          padding: 0 !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"section-padding\"]{\n" +
"          padding: 10px 15px 10px 15px !important;\n" +
"        }\n" +
"\n" +
"        td[class=\"section-padding-bottom-image\"]{\n" +
"          padding: 10px 15px 0 15px !important;\n" +
"        }\n" +
"\n" +
"        /* ADJUST BUTTONS ON MOBILE */\n" +
"        td[class=\"mobile-wrapper\"]{\n" +
"            padding: 10px 5% 15px 5% !important;\n" +
"        }\n" +
"\n" +
"        table[class=\"mobile-button-container\"]{\n" +
"            margin:0 auto;\n" +
"            width:100% !important;\n" +
"        }\n" +
"\n" +
"        a[class=\"mobile-button\"]{\n" +
"            width:80% !important;\n" +
"            padding: 15px !important;\n" +
"            border: 0 !important;\n" +
"            font-size: 16px !important;\n" +
"        }\n" +
"\n" +
"    }\n" +
"</style>\n" +
"</head>\n" +
"<body style=\"margin: 0; padding: 0;\" align=\"center\" bgcolor=\"#ffffff\">\n" +
"\n" +
"<!-- PREHEADER -->\n" +
"\n" +
"\n" +
"<table id=\"ko_titleBlock_3\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr class=\"row-a\">\n" +
"<td class=\"section-padding\" style=\"padding: 30px 15px 0px 15px;\" bgcolor=\"#c00000\" align=\"center\">\n" +
"            <table style=\"padding: 0 0 20px 0;\" class=\"responsive-table\" width=\"500\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n" +
"<!-- TITLE --><tbody><tr>\n" +
"<td class=\"padding-copy\" colspan=\"2\" style=\"padding: 0 0 10px 0px; font-size: 25px; font-family: Helvetica; font-weight: normal; color: #ffffff;\" align=\"center\"><strong>¡Welcome! "+usuario+"</strong></td>\n" +
"                </tr></tbody>\n" +
"</table>\n" +
"</td>\n" +
"    </tr></tbody></table>\n" +
"<table id=\"ko_onecolumnBlock_5\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr class=\"row-a\">\n" +
"<td class=\"section-padding\" style=\"padding-top: 30px; padding-left: 15px; padding-bottom: 30px; padding-right: 15px;\" bgcolor=\"#4bacc6\" align=\"center\">\n" +
"            <table class=\"responsive-table\" width=\"500\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td>\n" +
"                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>\n" +
"<tr>\n" +
"<td>\n" +
"                                    <!-- COPY -->\n" +
"                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody>\n" +
"<tr>\n" +
"<td class=\"padding-copy\" style=\"font-size: 25px; font-family: Helvetica, Arial, sans-serif; color: #3F3D33; padding-top: 0px;\" align=\"center\"><strong>We appreciate that you decided to join our community.</strong></td>\n" +
"                                        </tr>\n" +
"<tr>\n" +
"<td class=\"padding-copy textlightStyle\" style=\"padding: 20px 0 0 0; font-size: 16px; line-height: 25px; font-family: Helvetica; color: #000000;\" align=\"center\"><p style=\"margin:0px;\"><strong>Now we just need to verify your email account so you can start publishing your works.</strong><br></p></td>\n" +
"                                        </tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"                            </tr>\n" +
"<tr>\n" +
"<td>\n" +
"                                    <!-- BULLETPROOF BUTTON -->\n" +
"                                    <table class=\"mobile-button-container\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td style=\"padding: 25px 0 0 0;\" class=\"padding-copy\" align=\"center\">\n" +
"                                                <table class=\"responsive-table\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td align=\"center\"><a target=\"_new\" class=\"mobile-button\" style=\"display: inline-block; font-size: 18px; font-family: Helvetica, Arial, sans-serif; font-weight: normal; color: #ffffff; text-decoration: none; background-color: #9C010F; padding-top: 15px; padding-bottom: 15px; padding-left: 25px; padding-right: 25px; border-radius: 3px; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-bottom: 3px solid #5f0109;\" href=\""+url+"\"><strong>Verify email account</strong></a></td>\n" +
"                                                    </tr></tbody></table>\n" +
"</td>\n" +
"                                        </tr></tbody></table>\n" +
"</td>\n" +
"                            </tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"                </tr></tbody></table>\n" +
"</td>\n" +
"    </tr></tbody></table>\n" +
"<!-- FOOTER --><table style=\"min-width: 500px;\" id=\"ko_footerBlock_2\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr>\n" +
"<td bgcolor=\"#ffffff\" align=\"center\">\n" +
"            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody><tr>\n" +
"<td style=\"padding: 20px 0px 20px 0px;\">\n" +
"                        <!-- UNSUBSCRIBE COPY -->\n" +
"                        <table class=\"responsive-table\" width=\"500\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\"><tbody>\n" +
"<tr>\n" +
"<td style=\"font-size: 12px; line-height: 18px; font-family: Helvetica, Arial, sans-serif; color: #3F3D33;\" valign=\"middle\" align=\"center\">\n" +
"                                    <span class=\"appleFooter\" style=\"color: #3F3D33;\"><strong>If you are not "+usuario+" Or you think you received this email by error please ignore it</strong></span><br><a class=\"original-only\" href=\"%5Bprofile_link%5D\" style=\"color: #3F3D33; text-decoration: none;\" target=\"_new\"><br data-mce-bogus=\"1\"></a><span class=\"original-only\" style=\"font-family: Arial, sans-serif; font-size: 12px; color: #444444;\"> if the button doesn't work, try the following link or copy and paste in your web browser: <a href=\""+url+"\">"+url+"</a>     </span><a href=\"%5Bshow_link%5D\" style=\"color: #3F3D33; text-decoration: none;\" target=\"_new\"><br data-mce-bogus=\"1\"></a>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"<tr style=\"text-align: center;\">\n" +
"<td>\n" +
"                               \n" +
"                            </td>\n" +
"                            </tr>\n" +
"</tbody></table>\n" +
"</td>\n" +
"                </tr></tbody></table>\n" +
"</td>\n" +
"    </tr></tbody></table>\n" +
"</body>\n" +
"</html>\n" +
"";
    return cuerpo;
}
    
}
