$(function() {

  const appendBook = function(data) {
  var bookCode = "<a href='#' class='book-link' data-id='" + data.id + "'>" +
              data.name + "</a><br>";
              $("#book-list").append("<div>" + bookCode + "</div>");
  };

    //Show window specific book form
    $("#window-specific-book").click(function() {
            $("#specific-book-form").css("display", "flex");
    });

  //Show adding book form
  $("#show-form-add-book").click(function() {
          $("#book-form").css("display", "flex");
  });

  //Closing adding book form
  $("#book-form").click(function(event) {
          if(event.target === this) {
          $(this).css("display", "none");
          }
  });


  //Getting specific book
  $("#button-specific-book").click(function() {
          var data = $("#specific-book-form form").serialize();
          $.ajax({
              method: "GET",
              url: "/specificBookPage",
              data: data,
              success: function(response) {
              console.log("Return response '" + response + "'.");
                  $("#specific-book-form").css("display", "none");
                  var book = {};
                  book.id = response;
                  var dataArray = $("#specific-book-form form").serializeArray();
                  for(i in dataArray) {
                      console.log("Number current element '" + i + "' and his value '" + dataArray[i]["value"] + "' added.");
                      book[dataArray[i]["name"]] = dataArray[i]["value"];
                      console.log("Value book '" + book[dataArray[i]["name"]] + "'.");
                  }
              }
          });
          return false;
    });

  //Getting book
  $(document).on("click", ".book-link", function() {
          var link = $(this);
          var bookId = link.data("id");
          console.log("You click on link! Get id '" + bookId + "'.")

          $.ajax({
              method: "GET",
              url: "/books/" + bookId,
              success: function(response) {
                 var yearIsIssue = "<span>Year is issue: " + response.year + "</span>";
                 console.log("Year is issue book '" + yearIsIssue + "'.");
                 link.parent().append(yearIsIssue);
              },
              error: function(response) {
                 if(response.status == 404) {
                     alert("Book not found!");
                 }
              }
     });
     return false;
  });

  //Adding book
  $("#save-book").click(function() {
          var data = $("#book-form form").serialize();
          $.ajax({
              method: "POST",
              url: "/books/",
              data: data,
              success: function(response) {
              console.log("Return response '" + response + "'.");
                  $("#book-form").css("display", "none");
                  var book = {};
                  book.getId = response;
                  var dataArray = $("#book-form form").serializeArray();
                  for(i in dataArray) {
                      console.log("Number current element '" + i + "' and his value '" + dataArray[i]["value"] + "' added.");
                      book[dataArray[i]["name"]] = dataArray[i]["value"];
                      console.log("Value book '" + book[dataArray[i]["name"]] + "'.");
                  }
                  appendBook(book);
              }
          });
          return false;
    });
});