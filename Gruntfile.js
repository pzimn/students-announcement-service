'use strict';
module.exports = function(grunt) {
    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: ';',
            },
            js: {
                src: ['src/main/webapp/js/jq/*.js',
				'src/main/webapp/js/bootstrap/*.js',
				'src/main/webapp/js/lib/angular.min.js',
				'src/main/webapp/js/lib/*',
				'src/main/webapp/js/dx/*.js',
				'src/main/webapp/js/application/*.js',
				'src/main/webapp/js/controllers/*.js',
				'src/main/webapp/js/directives/*.js',
				'src/main/webapp/js/lib/services/*.js'],
                dest: 'src/main/webapp/dest/js/concat.js'
            },
            css: {
                src: ['src/main/webapp/styles/bootstrap/*.css',
				'src/main/webapp/styles/css/*.css',
				'src/main/webapp/styles/css/stylesheet.css',
				'src/main/webapp/styles/css/dx.common.css'],
                dest: 'src/main/webapp/dest/styles/concat.css'
            }
        },
        uglify: {
            options: {},
            dist: {
                files: {
                'src/main/webapp/dest/index.min.js': ['src/main/webapp/dest/js/concat.js']
                }
            }
        },
		cssmin : {
			target : {
				src : ["src/main/webapp/dest/styles/concat.css"],
				dest : "src/main/webapp/dest/styles.min.css"
			}
		}
    });

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-profile');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-cssmin');

    // Default task(s).
    grunt.registerTask('default', ['concat','uglify', 'cssmin']);

};