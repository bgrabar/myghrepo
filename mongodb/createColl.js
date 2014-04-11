for (x=1;x<=1000;x=x+25) {

  for (y=0;y<25;y++) {

    switch (y) {
      case 0: name = "elk" ;           traits = [ "antlers" ] ; break;
      case 1: name = "wolf" ;          traits = [ "paws" ] ; break;
      case 2: name = "hawk" ;          traits = [ "talons" ] ; break;
      case 3: name = "bear" ;          traits = [ "claws" ] ; break;
      case 4: name = "lynx" ;          traits = [ "claws" ] ; break;
      case 5: name = "rabbit" ;        traits = [ "ears" ] ; break;
      case 6: name = "coyote" ;        traits = [ "fangs" ] ; break;
      case 7: name = "woodchuck" ;     traits = [ "fur" ] ; break;
      case 8: name = "owl" ;           traits = [ "eyes" ] ; break;
      case 9: name = "yak" ;           traits = [ "mountains" , "horns" ] ; break;
      case 10: name = "deer" ;         traits = [ "horns" , "hills" , "woods" ] ; break;
      case 11: name = "camel" ;        traits = [ "humps" , "desert" ] ; break;
      case 12: name = "horse" ;        traits = [ "saddle" , "pasture" , "prairies" , "plains" ] ; break;
      case 13: name = "sheep" ;        traits = [ "wool" , "pasture" , "grasslands"] ; break;
      case 14: name = "bison" ;        traits = [ "horns" , "prairies" , "plains" , "grasslands" ] ; break;
      case 15: name = "llama" ;        traits = [ "wool" , "mountains" ] ; break;
      case 16: name = "alpaca" ;       traits = [ "wool" , "mountains" , "small" ] ; break;
      case 17: name = "wildebeest" ;   traits = [ "horns" , "grasslands" , "plains" ] ; break;
      case 18: name = "giraffe" ;      traits = [ "neck" ] ; break;
      case 19: name = "lion" ;         traits = [ "mane" ] ; break;
      case 20: name = "zebra" ;        traits = [ "stripes" ] ; break;
      case 21: name = "elephant" ;     traits = [ "tusks" ] ; break;
      case 22: name = "springbok" ;    traits = [ "none" ] ;  break;
      case 23: name = "rhinoceros" ;   traits = [ "horns" ] ; break;
      case 24: name = "hippopotamus" ; traits = [ "none" ] ; break;
    }
    db.anmls.insert( { n : (x + y ) , a : ( name ) , t : ( traits ) } ) 
  }
}
