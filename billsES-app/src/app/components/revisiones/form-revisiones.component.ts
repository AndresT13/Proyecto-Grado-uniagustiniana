import { Component, OnInit } from '@angular/core';
import { Revision } from '../../classes/revision';
import { RevisionService } from '../../services/revision.service';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClientService } from '../../services/http-client.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form-revisiones',
  templateUrl: './form-revisiones.component.html',
  styleUrls: ['./form-revisiones.component.css']
})
export class FormRevisionesComponent implements OnInit {


  private revision: Revision = new Revision();

  private titulo: string = "Formulario de Revisión";
  private titulo2: string = "Creación de Revisiones";


  constructor(private revisionService: RevisionService,
    private router: Router,
    private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarRevision();
  }

  cargarRevision(): void {
    this.activateRoute.params.subscribe( params => {
      let id = params['id']
      if(id) {
        this.revisionService.getRevision(id).subscribe((revision) => this.revision = revision);
      }
    })
  }

  create(): void {
    this.revisionService.create(this.revision)
    .subscribe(revision => {
      this.router.navigate(['/reviews']);
      swal.fire('Nueva Revisión', `Revisión ${revision.nombre} creada con éxito!`, 'success');
    });
  }

    update(): void {
      this.revisionService.update(this.revision)
      .subscribe( revision => {
        this.router.navigate(['/reviews']);
        swal.fire('Revisión Actualizada', `Revisión ${revision.nombre}`, 'success');
      });
    }


}
