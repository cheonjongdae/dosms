(function () {
  /* Imports */
  var $j = this.JpegMeta.JpegFile;

  /* Implementation */
  function $(x) {
    return document.getElementById(x);
  }

  function strComp(a, b) {
    return (a > b) ? 1 : (a == b) ? 0 : -1;
  }

  function loadFiles(files) {
    var dataurl_reader = new FileReader();

    function display(data, filename) {
      var jpeg = new $j(data, filename);
      var groups = new Array;
      var props;
      var group;
      var prop;
      //$("status").innerHTML += "JPEG File " + jpeg + "<br />";

      if (jpeg.gps && jpeg.gps.longitude) {
        //$("status").innerHTML += "<a href='http://maps.google.com/?q=" + jpeg.gps.latitude + "," + jpeg.gps.longitude + "&amp;spn=0.05,0.05&amp;t=h&amp;om=1&amp;hl=en' target='_blank'>Locate on map</a> (opens a new window) <br />";
      }

      for (group in jpeg.metaGroups) {
        if (jpeg.metaGroups.hasOwnProperty(group)) {
          groups.push(jpeg.metaGroups[group]);
        }
      }

      groups.sort(function (a, b) {
        if (a.description == "General") {
          return -1;
        } else if (b.description == "General") {
          return 1;
        } else {
          return strComp(a.description, b.description);
        }
      });

      for (var i = 0; i < groups.length; i++) {
        group = groups[i];
        props = new Array();
        //$("status").innerHTML += "<strong>" + group.description + "</strong><br />";
        for (prop in group.metaProps) {
          if (group.metaProps.hasOwnProperty(prop)) {
            props.push(group.metaProps[prop]);
          }
        }
        props.sort(function (a, b) { return strComp(a.description, b.description); });
        for (var j = 0; j < props.length; j++) {
          prop = props[j];
          if(prop.description == "Date Time Digitized" || prop.description == "Date Time Original" || prop.description == "Date and time") {
        	  
            var trans = prop.value.replace(/[^0-9]/g,"") % 1000000000000;
            $("status2").value = parseInt(trans / 1000000);
            $("status3").value = trans % 1000000;
            
            $("status").innerHTML += parseInt($("status3").value / 10000) + " : "
            						+ parseInt($("status3").value % 10000 / 100) + " : "
            						+ $("status3").value % 100;
            return;
          }
          //$("status").innerHTML += "<em>" + prop.description + ":</em> " + prop.value + "<br />";
        }
      }
    }

    dataurl_reader.onloadend = function() {
      $("img").src = this.result;
      display(atob(this.result.replace(/^.*?,/,'')), files[0]);
    }

    $("status2").value = "";
    $("status3").value = "";
    $("status").innerHTML = "";
    $("img").src = "";
    dataurl_reader.readAsDataURL(files[0]);
    $("eform").reset();

  }

  window.onload = function() {
    var file_el = $("fileWidget");
    file_el.addEventListener("change", function() { loadFiles(this.files); }, true);
  }
  /* No exports */
})();
