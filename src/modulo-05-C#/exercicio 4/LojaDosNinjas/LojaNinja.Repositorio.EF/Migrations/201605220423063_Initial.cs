namespace LojaNinja.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Pedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataPedido = c.DateTime(nullable: false),
                        DataEntregaDesejada = c.DateTime(nullable: false),
                        NomeProduto = c.String(),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        TipoDePagamento = c.Int(nullable: false),
                        NomeCliente = c.String(),
                        Cidade = c.String(),
                        Estado = c.String(),
                        PedidoUrgente = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(),
                        Senha = c.String(),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        Usuario_Id = c.Int(nullable: false),
                        Permissao_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Usuario_Id, t.Permissao_Id })
                .ForeignKey("dbo.Usuario", t => t.Usuario_Id, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.Permissao_Id, cascadeDelete: true)
                .Index(t => t.Usuario_Id)
                .Index(t => t.Permissao_Id);
            Sql(@"INSERT INTO Usuario 
                        (Email
                        ,Senha
                        ,Nome) 
                    VALUES 
                        ('ben-hur@cwi.com.br'
                        ,'72f3f890e32827717f8a18c09b670394'
                        ,'Ben-hur')
                  GO");

            /*
             * O mesmo para permissões...
             */
            Sql(@"INSERT INTO [dbo].[Permissao]
			                ([Nome])
		                VALUES
			                ('COMUM'),
			                ('ADMIN')
                GO");

            /*
             * ... E para linkar usuários com permissões.
             */
            Sql(@"INSERT INTO [dbo].[UsuarioPermissao]
			                ([Usuario_Id]
			                ,[Permissao_Id])
		                VALUES
			                ((SELECT Id FROM Usuario WHERE Email = 'ben-hur@cwi.com.br'),
			                 (SELECT Id FROM Permissao WHERE Nome = 'ADMIN'))
                GO");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "Permissao_Id", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "Usuario_Id", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "Permissao_Id" });
            DropIndex("dbo.UsuarioPermissao", new[] { "Usuario_Id" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Pedido");
        }
    }
}
