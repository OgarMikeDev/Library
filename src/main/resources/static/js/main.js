$(function() {

  const appendBook = function(data) {
  var bookCode = "<a href='#' class='book-link' data-id='" + data.id + "'>" +
              data.name + "</a><br>";
              $("#book-list").append("<div>" + bookCode + "</div>");
  };

//  //Loading books on load page
//  $.get("/books/", function(response) {
//         for(i in response) {
//         console.log("Number huy: " + i);
//             appendBook(response[i]);
//         }
//  });

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
                  $("#book-form").css("display", "none");
                  var book = {};
                  book.id = response;
                  var dataArray = $("#book-form form").serializeArray();
                  for(i in dataArray) {
                      console.log("Number current element '" + i + "' and his value '" + dataArray[i]["value"] + "' added.");
                      book[dataArray[i]["name"]] = dataArray[i]["value"];
                  }
                  console.log("Name book '" + book.name +
                  "' and year her is issue '" + book.year + "' added.");
                  appendBook(book);
              }
          });
          return false;
    });
});