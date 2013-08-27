for (w=0;w<99999;w=w+1000) {

  for (x=0;x<1000;x=x+100) {

    for (y=0;y<100;y=y+10) {

      for (z=1;z<10;z=z+1) {

       switch ((z+3)%3) {

         case 0: tmp = "anytown" ; break;

         case 1: tmp = "smallville" ; break;

         case 2: tmp = "big city" ; break;

       }

       db.numbers_collection.insert( { zip : ( w + x + y + z ) , town : tmp } ) } } } }

