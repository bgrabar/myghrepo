for (x=1;x<=1000000;x=x+19) {

  for (y=0;y<19;y++) {

    switch (y) {
      case 0: tmp1 = "Smith" ; tmp2 = [ "Morrissey", "Johnny", "Mike", "Andy", "Craig" ] ; break;
      case 1: tmp1 = "Jones" ; tmp2 = [ "Frank", "Carlos", "Anita", "Eva", "John", "Kim" ] ; break;
      case 2: tmp1 = "Brown" ; tmp2 = [ "James", "Gordon", "Tom" ] ; break;
      case 3: tmp1 = "Washington" ; tmp2 = [ null ] ; break;
      case 4: tmp1 = "Lincoln" ; tmp2 = [ "Robert Todd", "Eddie", "Willie", "Tad" ] ; break;
      case 5: tmp1 = "Coolidge" ; tmp2 = [ "John", "Calvin" ] ; break;
      case 6: tmp1 = "Kernighan" ; tmp2 = [ "Larry", "Lori", "Laura", "Lyle" ] ; break;
      case 7: tmp1 = "Ritchie" ; tmp2 = [ "Peggy", "Vicky" ] ; break;
      case 8: tmp1 = "Kennedy" ; tmp2 = [ "Joe", "John", "Rose", "Kathleen", "Eunice", "Patricia", "Robert", "Jean", "Ed" ] ; break;
      case 9: tmp1 = "Johnson" ; tmp2 = [ "Luci", "Lynda Bird" ] ; break;
      case 10: tmp1 = "Nixon" ; tmp2 = [ "Tricia", "Julie"] ; break;
      case 11: tmp1 = "Ford" ; tmp2 = [ "Susan", "Steven", "Michael", "John" ] ; break;
      case 12: tmp1 = "Carter" ; tmp2 = [ "Donnel", "Jack", "James", "Amy" ] ; break;
      case 13: tmp1 = "Reagan" ; tmp2 = [ "Michael", "Maureen", "Patti", "Ron" ] ; break;
      case 14: tmp1 = "Brady" ; tmp2 = [ "Greg", "Marsha", "Peter", "Jan", "Cindy", "Bobby" ] ; break;
      case 15: tmp1 = "Rockford" ; tmp2 = [ "Dennis", "Dan", "Doreen", "Dana" ] ; break;
      case 16: tmp1 = "Smith" ; tmp2 = [ "Veronica", "Luke" ] ; break;
      case 17: tmp1 = "Doctorow" ; tmp2 = [ "Frank", "Mark", "James", "Holly" ] ; break;
      case 18: tmp1 = "McDougal" ; tmp2 = [ "Bruce",  "Matthew", "Chip", "Holly" ] ; break;
    }

    db.survey.insert( { n : (x + y ), household : ( tmp1 ), children : ( tmp2 ) } )

  }

}
