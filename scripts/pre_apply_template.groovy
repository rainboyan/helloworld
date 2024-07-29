println 'Pre Apply Application Template'

println "Starting to apply application template by ${project.graceVersion}"

ant.sequential {

    say "Create my Blog"

    file(name: 'package.json', '''
{
    "private": true,
    "dependencies": {
        "bootstrap": "^5.3.3",
        "htmx.org": "^1.9.10",
        "hyperscript.org": "^0.9.12"
    }
}
''')
    npm("install")
    npm("install jquery")

    file(name: ".gitignore", append: 'yes', 'node_modules')

    file(name: "app/domain/${properties['grace.codegen.defaultPackage.path']}/Post.groovy",
    '''package grace.apps

class Post {
    String title
    String content
}
''')

}
