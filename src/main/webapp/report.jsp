<%--
  Created by IntelliJ IDEA.
  User: elifsen
  Date: 11.08.2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="html2pdf.bundle.js"></script>
<script>
  function toPdf() {
    debugger;
    const element = document.getElementById("patientForm");
    html2pdf()
            .from(element)
            .save();
    var mi = "blabla";
    print("beni çağırdın");
    print(mi);

  }
</script>
<title>Document</title>
</head>
<style>
  table, th, td,pre {
    border:0.5px solid black;
  }
</style>
<body>



<h2>Hasta Raporu</h2>

<table id="patientForm" style="width:100%">
  <tr>
    <th>Company</th>
  </tr>
  <table  style="width:100%">
    <tr>
      <td>Adı Soyadı</td>
      <td>Maria Anders</td>
    </tr>
    <tr>
      <td>Doğum Tarihi</td>
      <td>Francisco Chang</td>
    </tr>
    <tr>
      <td>Veriliş Nedeni</td>
      <td></td>
    </tr>
    <tr>
      <td>Baba Adı</td>
      <td>Francisco Chang</td>
    </tr>
    <tr>
      <td>T.C. Kimlik Numarası</td>
      <td>Francisco Chang</td>
    </tr>
    <tr>
      <td>Düzenlenme Tarihi</td>
      <td>Francisco Chang</td>
    </tr>
    <tr>
      <td>Adres</td>
      <td>Francisco Chang</td>
    </tr>
  </table>
  <br>
  <br>
  <br>
  <table style="width:100%">
    <tr>
      <th>ICPC KODU VE TANI(LAR) <th>
    </tr>
  </table>
  <fieldset>jçxbkcvdsçduglfcbksjçhçdgvlskçdçvaıcsydlıasbdhclıshks
    jxvzjhvxjzhcvhjzcvkzvczöjxcvhzcvzjcvhzjcvzxjövchzm
    cvzvxcjözvxcjkshglkscgbzjkcvböjzhvxczzc</fieldset>



  <table style="width:100%">
    <tr>
      <th>BULGULAR: </th>
    </tr>
  </table>


  <fieldset>


    <div>
      <input type="checkbox" id="uygun" name="uygun"
             checked>
      <label for="uygun">Yukarıda bilgileri bulunan şahsıın düzenlemiş olduğu bilgi formu ve ... tarihinde yapılan muayenesi sonucunda ... engel bir durumu olmadığını bildirir hekim kanaat raporudur</label>
    </div>

    <div>
      <input type="checkbox" id="sevk" name="sevk">
      <label for="sevk">Yukarıda bilgileri bulunan şahsın düzenlemiş olduğu bilgi formu ve ... tarihinde yapılan fiziki muayenesi sonucunda bir üst sağlık basamağına sevk edilmesi uygundur </label>
    </div>
  </fieldset>
</table>

<button onclick="toPdf()">Raporu İndir</button>


</body>
</html>
</html>
