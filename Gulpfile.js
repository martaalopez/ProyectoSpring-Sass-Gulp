const { src, dest, watch, series } = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const postcss = require('gulp-postcss');
const autoprefixer = require('autoprefixer');

function css(done) {
    src('src/main/resources/static/scss/styles.scss')
        .pipe(sass())
        .pipe(dest('src/main/resources/static/css'))
        .pipe(postcss([autoprefixer()]));
    done();
}

function dev() {
    watch('src/main/resources/static/scss/**/*.scss', css);
    imagenes('src/main/resources/img/*',imagenes);
}

async function imagenes() {
    const imagemin = await import('gulp-imagemin');

    return src('src/main/resources/img/*')
        .pipe(imagemin.default({ optimizationLevel: 3 }))
        .pipe(dest('src/main/resources/static/img'));
}

/*para leerlo*/
exports.css = css;
exports.dev = dev;
exports.imagenes = imagenes;
exports.default = series(css, dev, imagenes);
