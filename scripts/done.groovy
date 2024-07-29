println 'Post Generate Project'

ant.say 'Done!'

ant.grace('create-domain-class': 'User')
ant.grace('generate-all': 'User')

ant.gradle('bootJar')
