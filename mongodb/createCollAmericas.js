for (x=1;x<=1000000;x=x+8) {

  for (y=0;y<8;y++) {

    switch (y) {
      case 0: tmp1 = "elk" ; break;
      case 1: tmp1 = "wolf" ; break;
      case 2: tmp1 = "hawk" ; break;
      case 3: tmp1 = "bear" ; break;
      case 4: tmp1 = "lynx" ; break;
      case 5: tmp1 = "rabbit" ; break;
      case 6: tmp1 = "coyote" ; break;
      case 7: tmp1 = "woodchuck" ; break;
    }

    db.americas.insert( { n : (x + y ) , a : ( tmp1 ) } ) 

  }

}
