$(document).ready(function(){
    $('.content').slick({
        slidesToShow: 1,
         slidesToScroll: 1,
 //  infinite: true,
 // autoplay: true,
  // autoplaySpeed: 3000,
//    arrows: false,
    prevArrow:"<button type='button' class='slick-prev pull-left'><i class='bx bx-left-arrow-alt' aria-hidden='true'></i></button>",
    nextArrow:"<button type='button' class='slick-next pull-right'><i class='bx bx-right-arrow-alt' aria-hidden='true'></i></button>",
   dots: true,
    });
  });