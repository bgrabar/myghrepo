for (x=1;x<=5000000;x=x+25) {

  for (y=0;y<25;y++) {

    switch (y) {
      case 0: tmp1 = "elk" ; tmp2 = "antlers" ; break;
      case 1: tmp1 = "wolf" ; tmp2 = "paws" ; break;
      case 2: tmp1 = "hawk" ; tmp2 = "talons" ; break;
      case 3: tmp1 = "bear" ; tmp2 = "claws" ; break;
      case 4: tmp1 = "lynx" ; tmp2 = "claws" ; break;
      case 5: tmp1 = "rabbit" ; tmp2 = "ears" ; break;
      case 6: tmp1 = "coyote" ; tmp2 = "fangs" ; break;
      case 7: tmp1 = "woodchuck" ; tmp2 = "fur" ; break;
      case 8: tmp1 = "owl" ; tmp2 = "eyes" ; break;
      case 9: tmp1 = "yak" ; tmp2 = "horns" ; break;
      case 10: tmp1 = "deer" ; tmp2 = "antlers" ; break;
      case 11: tmp1 = "camel" ; tmp2 = "humps" ; break;
      case 12: tmp1 = "horse" ; tmp2 = "saddle" ; break;
      case 13: tmp1 = "sheep" ; tmp2 = "wool" ; break;
      case 14: tmp1 = "bison" ; tmp2 = "horns" ; break;
      case 15: tmp1 = "llama" ; tmp2 = "wool" ; break;
      case 16: tmp1 = "alpaca" ; tmp2 = "wool" ; break;
      case 17: tmp1 = "wildebeest" ; tmp2 = "horns" ; break;
      case 18: tmp1 = "giraffe" ; tmp2 = "neck" ; break;
      case 19: tmp1 = "lion" ; tmp2 = "mane" ; break;
      case 20: tmp1 = "zebra" ; tmp2 = "stripes" ; break;
      case 21: tmp1 = "elephant" ; tmp2 = "tusks" ; break;
      case 22: tmp1 = "springbok" ; tmp2 = "none" ;  break;
      case 23: tmp1 = "rhinoceros" ; tmp2 = "horns" ; break;
      case 24: tmp1 = "hippopotamus" ; tmp2 = "none" ;  break;
    }

    db.all.insert( { n : (x + y ) , type : ( tmp1 ) , trait : ( tmp2 ) } ) 

  }

}
