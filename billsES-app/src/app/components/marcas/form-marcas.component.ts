import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/classes/marca';
import { MarcaService } from '../../services/marca.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-form-marcas',
  templateUrl: './form-marcas.component.html',
  styleUrls: ['./form-marcas.component.css']
})
export class FormMarcasComponent implements OnInit {

  private marca: Marca = new Marca();

  private titulo: string = 'Formulario de Marcas';
  private titulo2: string = 'Creación de Marcas'

  constructor(private marcasService: MarcaService,
    private router: Router,
    private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarMarca();
  }

cargarMarca(): void {
  this.activateRoute.params.subscribe( params => {
    let id = params['id']
    if (id) {
      this.marcasService.getMarca(id).subscribe((marca) => this.marca = marca)
    }
  }
  );
}

  create(): void {
    this.marcasService.create(this.marca)
    .subscribe(marca =>
       {
         this.router.navigate(['/brands'])
         swal.fire('Nueva Marca', `Marca ${marca.nombre} creada con éxito!`, 'success')
       }
      );
  }


  update(): void {
    this.marcasService.update(this.marca)
    .subscribe(marca => {
      this.router.navigate(['/brands'])
      swal.fire('Marca actualizada', `Marca ${marca.nombre} actualizada con éxito!`, 'success')
    }
    );
  }

}
