import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-guide-tour',
  templateUrl: './guide-tour.component.html',
  styleUrls: ['./guide-tour.component.css']
})
export class GuideTourComponent implements OnInit {
  guideTours = [
    {
      id: '1',
      name: 'Marrakech Adventure',
      description: 'Explore the vibrant souks, historic palaces, and bustling markets of Marrakech.',
      location: 'Marrakech',
      price: 100,
      availability: true,
      imageUrl: 'assets/images/marrakech.jpg',
      rating: 4.5,
      highlights: ['Historic Medina', 'Safi Palace', 'Bab Marrakech']
    },
    {
      id: '2',
      name: 'Casablanca City Tour',
      description: 'Discover the modern cityscape of Casablanca, including its iconic landmarks and bustling neighborhoods.',
      location: 'Casablanca',
      price: 120,
      availability: true,
      imageUrl: 'assets/images/casa.jpg',
      rating: 4.7,
      highlights: ['Anfa', 'Casablanca City Center', 'Mohammed V Mausoleum']
    },
    {
      id: '3',
      name: 'Fes Exploration',
      description: 'Immerse yourself in the rich history and culture of Fes, known for its historic walled city and ancient mosques.',
      location: 'Fes',
      price: 80,
      availability: true,
      imageUrl: 'assets/images/fes.jpg',
      rating: 4.8,
      highlights: ['Historic Walled City', 'Mosque of Hassan II', 'Medersa Bou Inania']
    },
    {
      id: '4',
      name: 'Agadir Beach Escape',
      description: 'Relax on the beautiful beaches of Agadir and enjoy the vibrant nightlife of the city.',
      location: 'Agadir',
      price: 150,
      availability: true,
      imageUrl: 'assets/images/agadir.jpg',
      rating: 4.6,
      highlights: ['Agadir Beach', 'Agadir Nightlife', 'Agadir Museum']
    },
    {
      id: '5',
      name: 'Rabat Royal Tour',
      description: 'Experience the rich history and modern architecture of Rabat, the capital city of Morocco.',
      location: 'Rabat',
      price: 110,
      availability: true,
      imageUrl: 'assets/images/rabat.jpg',
      rating: 4.9,
      highlights: ['Rabat Medina', 'Rabat City Center', 'Mausoleum of Mohammed V']
    },
    {
      id: '6',
      name: 'Ouarzazate Desert Adventure',
      description: 'Discover the stunning landscapes of the Sahara Desert in Ouarzazate, including the famous filming locations of the "Mad Max" series.',
      location: 'Ouarzazate',
      price: 130,
      availability: true,
      imageUrl: 'assets/images/ouarzazate.jpg',
      rating: 4.4,
      highlights: ['Sahara Desert', 'Filming Locations', 'Ouarzazate Market']
    },
    {
      id: '7',
      name: 'Chefchaouen Artistic Journey',
      description: 'Explore the vibrant colors and artistic heritage of Chefchaouen, known for its blue-painted houses and traditional Moroccan crafts.',
      location: 'Chefchaouen',
      price: 90,
      availability: true,
      imageUrl: 'assets/images/chefchaouen.jpg',
      rating: 4.7,
      highlights: ['Blue Houses', 'Artistic Crafts', 'Chefchaouen Market']
    },
    {
      id: '8',
      name: 'Tangier Medieval City Tour',
      description: 'Step back in time in Tangier, a city that blends modernity with its rich historical roots, including the famous Kasbah of Tangier.',
      location: 'Tangier',
      price: 140,
      availability: true,
      imageUrl: 'assets/images/tangier.jpg',
      rating: 4.5,
      highlights: ['Kasbah of Tangier', 'Medina of Tangier', 'Tangier Beach']
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }
}
