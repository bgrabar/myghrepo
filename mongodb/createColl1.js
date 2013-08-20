for (x=1;x<=1000000;x=x+8) {

  for (y=0;y<8;y++) {

    switch (y) {
      case 0: tmp1 = "owl" ; break;
      case 1: tmp1 = "lion" ; break;
      case 2: tmp1 = "zebra" ; break;
      case 3: tmp1 = "giraffe" ; break;
      case 4: tmp1 = "elephant" ; break;
      case 5: tmp1 = "springbok" ; break;
      case 6: tmp1 = "rhinoceros" ; break;
      case 7: tmp1 = "hippopotamus" ; break;
    }

    db.africa.insert( { n : (x + y ) , type : ( tmp1 ) } ) 

  }

}
