import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { BookingComponent } from './components/booking/booking.component';
import { CustomerLoginComponent } from './components/customer-login/customer-login.component';
import { CustomerRegisterComponent } from './components/customer-register/customer-register.component';
import { CustomerReviewComponent } from './components/customer-review/customer-review.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PageGuard } from './page.guard';
import { CitiesComponent } from './components/cities/cities.component';
import { GuideTourComponent } from './components/guide-tour/guide-tour.component';

const routes: Routes = [
  {
    path: '',
    component: CustomerLoginComponent,
    canActivate: [PageGuard],
  },
  {
    path: 'register',
    component: CustomerRegisterComponent,
    canActivate: [PageGuard],
  },
  {
    path: 'dashboard',
    component: WelcomeComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'booking',
    component: BookingComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'review',
    component: CustomerReviewComponent,
    canActivate: [AuthGuard],
  },
  {
  path: 'guide-tour',
  component: GuideTourComponent,
  canActivate: [AuthGuard],
},
  {
  path: 'cities',
  component: CitiesComponent,
  canActivate: [AuthGuard],
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
