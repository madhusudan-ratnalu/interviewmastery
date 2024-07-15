document.getElementById('addQuestion').onclick = function() {
  var questionDiv = document.createElement('div');
  questionDiv.innerHTML = '<label>Question: <input type="text" name="questions[]"></label><br>\
  <label>Component: <select name="components[]">\
    <option value="spring">Spring</option>\
    <option value="spring-boot">Spring Boot</option>\
    <option value="hld">HLD</option>\
    <option value="lld">LLD</option>\
  </select></label><br>';
  document.getElementById('questions').appendChild(questionDiv);
};

    var currentSection = 0;
    var sections = document.getElementsByClassName('section');
    document.getElementById("prev").disabled = true;
    document.getElementById("submit").style.display = 'none';

    function showSection(n) {
      sections[currentSection].classList.remove('show');
      sections[n].classList.add('show');

      sections[currentSection].style.display = "none";
      sections[n].style.display = "block";
      currentSection = n;

      if(currentSection === 0) {
        document.getElementById("prev").disabled = true;
      } else {
        document.getElementById("prev").disabled = false;
      }
      if(currentSection === sections.length - 1) {
        document.getElementById("next").style.display = 'none';
        document.getElementById("submit").style.display = 'inline-block';
      } else {
        document.getElementById("next").style.display = 'inline-block';
        document.getElementById("submit").style.display = 'none';
      }
    }

    showSection(0);

    document.getElementById("next").addEventListener("click", function() {
      showSection(currentSection + 1);
    });

    document.getElementById("prev").addEventListener("click", function() {
      showSection(currentSection - 1);
    });