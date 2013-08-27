for (w=53000;w<60000;w=w+1000) {

  for (x=100;x<1000;x=x+100) {

    for (y=10;y<100;y=y+10) {

      for (z=0;z<10;z=z+1) {

        db.contacts.insert( { zip : ( w + x + y + z ) , town : "whatever" } ) 

} } } }
