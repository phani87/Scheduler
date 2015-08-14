/**
 * 
 */

 $(function () {
  var isMouseDown = false,
    isHighlighted;
  $("#data td")
    .mousedown(function () {
      isMouseDown = true;
      $(this).toggleClass("highlighted");
      isHighlighted = $(this).hasClass("highlighted");
      return false; // prevent text selection
    })
    .mouseover(function () {
      if (isMouseDown) {
        $(this).toggleClass("highlighted", isHighlighted);
      }
    });

  $(document)
    .mouseup(function () {
      isMouseDown = false;
    });
});
 
 