import {html2pdf} from "./html2pdf.bundle";

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