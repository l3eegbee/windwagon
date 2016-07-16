package com.windwagon.broceliande.knights.forge;

public interface ActorVisitor<R> {

    default public R visitComponent( ComponentWrapper wrapper ) {
        throw new RuntimeException( "Unexpected visit of " + wrapper.getClass() );
    }

    default public R visitNull( NullComponentWrapper wrapper ) {
        return visitComponent( wrapper );
    }

    default public R visitActor( ActorWrapper<?, ?> wrapper ) {
        return visitComponent( wrapper );
    }

    default public R visitWrappedKnight( WrappedKnight<?> wrapper ) {
        return visitActor( wrapper );
    }

    default public R visitKnight( KnightWrapper wrapper ) {
        return visitWrappedKnight( wrapper );
    }

    default public R visitOfficialKnight( OfficialKnightWrapper wrapper ) {
        return visitWrappedKnight( wrapper );
    }

    default public R visitPage( PageWrapper wrapper ) {
        return visitActor( wrapper );
    }

    default public R visitTask( TaskWrapper<?, ?, ?> wrapper ) {
        return visitActor( wrapper );
    }

    default public R visitFencingMaster( FencingMasterWrapper wrapper ) {
        return visitTask( wrapper );
    }

    default public R visitBrotherhood( BrotherhoodWrapper wrapper ) {
        return visitTask( wrapper );
    }

    default public R visitScribe( ScribeWrapper wrapper ) {
        return visitTask( wrapper );
    }

}
