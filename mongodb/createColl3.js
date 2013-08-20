for (x=1;x<=1000000;x=x+9) {

  for (y=0;y<9;y++) {

    switch (y) {
      case 0: tmp1 = "yak" ; tmp2 = [ "mountains" , "horns" ] ; break;
      case 1: tmp1 = "deer" ; tmp2 = [ "horns" , "hills" , "woods" ] ; break;
      case 2: tmp1 = "camel" ; tmp2 = [ "humps" , "desert" ] ; break;
      case 3: tmp1 = "horse" ; tmp2 = [ "saddle" , "pasture" , "prairies" , "plains" ] ; break;
      case 4: tmp1 = "sheep" ; tmp2 = [ "wool" , "pasture" , "grasslands"] ; break;
      case 5: tmp1 = "bison" ; tmp2 = [ "horns" , "prairies" , "plains" , "grasslands" ] ; break;
      case 6: tmp1 = "llama" ; tmp2 = [ "wool" , "mountains" ] ; break;
      case 7: tmp1 = "alpaca" ; tmp2 = [ "wool" , "mountains" , "small" ] ; break;
      case 8: tmp1 = "wildebeest" ; tmp2 = [ "horns" , "grasslands" , "plains" ] ; break;
    }

    db.animals.insert( { n : (x + y ) , type : ( tmp1 ) , traits : ( tmp2 ) } ) 

  }

}
