import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/classes/usuario';
import { HttpClientService } from 'src/app/services/http-client.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2'
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-form-usuarios',
  templateUrl: './form-usuarios.component.html',
  styleUrls: ['./form-usuarios.component.css']
})
export class FormUsuariosComponent implements OnInit {

  private usuario: Usuario = new Usuario;


  private titulo: string = "Formulario de Usuario";
  private titulo2: string = "Creación de Usuarios";


  constructor(private usuarioService: HttpClientService,
     private router: Router,
     private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this. cargarUsuario();
  }

  cargarUsuario(): void {
    this.activatedRoute.params.subscribe( params => {
        let id = params['id']
        if (id) {
          this.usuarioService.getUsuario(id).subscribe((usuario) => this.usuario = usuario);
        }
      }

    );

  }

  create(): void {
   /*  console.log("Usuario ok")
    console.log(this.usuario) */
    this.usuarioService.create(this.usuario)
      .subscribe(usuario => {
      this.router.navigate(['/users']);
        swal.fire('Nuevo Usuario', `El usuario: ${ usuario.nombre }: ha sido creado con éxito!`, 'success');
    }
    );

  }

  update(): void {
this.usuarioService.update(this.usuario)
.subscribe( usuario => {
  this.router.navigate(['/users']);
  swal.fire('Usuario Actualizado', `El usuario ${usuario.nombre} actualizado con éxito!`, 'success');
}
);

  }
}
