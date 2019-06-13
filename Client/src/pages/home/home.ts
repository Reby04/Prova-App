import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { TranslateService } from '@ngx-translate/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { Observable } from '../../../node_modules/rxjs/Observable';
import AddomiPage from '../addomi/addomi';
import {CoscePage} from "../cosce/cosce";
import {GluteiPage} from "../glutei/glutei";
// import { AccountPage } from '../account/account';
// import { RoutinePage } from '../routine/routine';
// import { CreaSchedaPage } from '../crea-scheda/crea-scheda';

@Component({
  selector: 'page-home',
 templateUrl: 'home.html'
  })


export class HomePage {

  result:any = [];
  data: Observable<any>;
  constructor(public navCtrl: NavController, translate: TranslateService, public http: HttpClient) {
    translate.setDefaultLang('it');
    translate.use('en');
  }

  addomi(x: number) {
    if (x == 1)
   this.navCtrl.push(AddomiPage, {
     Item: 1
   });
   else 
   if (x == 2)
   this.navCtrl.push(AddomiPage, {
    Item: 2
  });
   else
   this.navCtrl.push(AddomiPage, {
    Item: 3
  });
  }

  glutei(x: number) {
    if (x == 1)
   this.navCtrl.push(GluteiPage, {
     Item: 1
   });
   else 
   if (x == 2)
   this.navCtrl.push(GluteiPage, {
     Item: 2
   });
   else
   this.navCtrl.push(GluteiPage, {
     Item: 3
   });
  }

  gambe(x: number) {
    if (x == 1)
   this.navCtrl.push (CoscePage, {
     Item: 1
   })
   ;
   else 
   if (x == 2)
   this.navCtrl.push(CoscePage, {
     Item: 2
   });
   else
   this.navCtrl.push(CoscePage, {
     Item:3
   });
  }

}
