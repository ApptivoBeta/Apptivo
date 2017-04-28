using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Apptivo.Startup))]
namespace Apptivo
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
